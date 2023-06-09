package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;
import com.besysoft.taller_mecanico.domain.entity.Repuesto;

import java.util.List;

public interface MecanicaService {

    List<ManoObra> listarManosDeObraAsignadas(Long mecanicoId);

    void iniciarReparacion(Long manoObraid);

    void finalizarReparacion(Long manoObraId, String detalle, Long duracion_hs);

    void cargarRepuestos(Long manoObraId, Repuesto repuestos, Integer cantidad);

    void ordenParaFacturar(Long manoObraId);

}
