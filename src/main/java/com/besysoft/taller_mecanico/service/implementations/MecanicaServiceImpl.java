package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;
import com.besysoft.taller_mecanico.domain.enumerations.EstadoOrdenEnum;
import com.besysoft.taller_mecanico.repository.ManoObraRepository;
import com.besysoft.taller_mecanico.repository.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicaService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MecanicaServiceImpl implements MecanicaService {

    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final ManoObraRepository manoObraRepository;

    public MecanicaServiceImpl(OrdenTrabajoRepository ordenTrabajoRepository, ManoObraRepository manoObraRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.manoObraRepository = manoObraRepository;
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
    public void finalizarReparacion(Long manoObraId, String detalle, LocalTime duracion_hs) {

        ManoObra manoObraAsignada = this.manoObraRepository.findById(manoObraId).orElseThrow();

        manoObraAsignada.setDetalle(detalle);
        manoObraAsignada.setDuracionHs(duracion_hs);

        manoObraRepository.save(manoObraAsignada);

    }

    @Override
    public void cargarRepuestos(Long manoObraId, Repuesto repuesto) {

    }
}
