package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.domain.entity.ManoObra;

import java.time.LocalTime;
import java.util.List;

public interface MecanicaService {

    List<ManoObra> listarManosDeObraAsignadas(Long mecanicoId);

    void completarManoObra(Long manoObraId, String detalle, LocalTime duracion_hs);
}
