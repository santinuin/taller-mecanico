package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.repository.DetalleOrdenTrabajoRepository;
import com.besysoft.taller_mecanico.repository.ManoObraRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MecanicaServiceImpl implements MecanicaService {

    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final ManoObraRepository manoObraRepository;
    private final DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    public MecanicaServiceImpl(OrdenTrabajoRepository ordenTrabajoRepository,
                               ManoObraRepository manoObraRepository,
                               DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository) {

        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.manoObraRepository = manoObraRepository;
        this.detalleOrdenTrabajoRepository = detalleOrdenTrabajoRepository;
    }


    @Override
    public List<ManoObra> listarManosDeObraAsignadas(Long mecanicoId) {
        return this.manoObraRepository.findByMecanico_Id(mecanicoId).stream()
                .filter(x -> x.getOrdenTrabajo().getEstado() == EstadoOrdenEnum.CREADA)
                .collect(Collectors.toList());
    }

    @Override
    public void iniciarReparacion(Long manoObraId) {
        OrdenTrabajo ordenTrabajo = this.manoObraRepository.findById(manoObraId).get().getOrdenTrabajo();
        ordenTrabajo.setEstado(EstadoOrdenEnum.EN_REPARACION);
        ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Override
    public void finalizarReparacion(Long manoObraId, String detalle, Long duracion_hs) {

        ManoObra manoObraAsignada = this.manoObraRepository.findById(manoObraId).orElseThrow();
        OrdenTrabajo ordenTrabajo = this.ordenTrabajoRepository.findById(manoObraAsignada.getOrdenTrabajo().getId()).orElseThrow();

        ordenTrabajo.setFechaFinReparacion(LocalDateTime.now());

        manoObraAsignada.setDetalle(detalle);
        manoObraAsignada.setDuracionHs(Duration.ofHours(duracion_hs));

        manoObraRepository.save(manoObraAsignada);

    }

    @Override
    public void cargarRepuestos(Long manoObraId, Repuesto repuesto, Integer cantidad) {

        DetalleOrdenTrabajo detalleOrdenTrabajo = new DetalleOrdenTrabajo();
        OrdenTrabajo ordenTrabajo = this.manoObraRepository.findById(manoObraId).get().getOrdenTrabajo();

        detalleOrdenTrabajo.setOrdenTrabajo(ordenTrabajo);
        detalleOrdenTrabajo.setRepuesto(repuesto);
        detalleOrdenTrabajo.setCantidad(cantidad);

        BigDecimal valor_total = repuesto.getValor().multiply(BigDecimal.valueOf(cantidad));
        detalleOrdenTrabajo.setValorTotal(valor_total);


        this.detalleOrdenTrabajoRepository.save(detalleOrdenTrabajo);

    }

    @Override
    public void ordenParaFacturar(Long manoObraId) {

        OrdenTrabajo ordenTrabajo = this.manoObraRepository.findById(manoObraId).get().getOrdenTrabajo();

        ordenTrabajo.setEstado(EstadoOrdenEnum.PARA_FACTURAR);

        this.ordenTrabajoRepository.save(ordenTrabajo);
    }


}
