package com.salesianostriana.dam.monumentosv2.repository;

import com.salesianostriana.dam.monumentosv2.model.Monumento;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();

    @PostConstruct
    public void init(){
        add(Monumento.builder()
                .id(1L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Úbeda")
                .latitud(38.01194)
                .longitud(-3.38034)
                .nombre("Hospital de Santiago Úbeda")
                .descripcion("El hospital de Santiago es un monumento nacional situado en la ciudad de Úbeda, Jaén. Proyectado por Andrés de Vandelvira en 1562, las obras finalizaron en 1575, como consta en el testero de la escalera.")
                .imagen("https://cloud.inspain.org/imgwbp/sitios/1/1/8/ay3pje36bku5eh4bm7a43f7cgm_2000.webp")
                .build());

        add(Monumento.builder()
                .id(2L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Granada")
                .latitud(37.17607)
                .longitud(-3.58814)
                .nombre("Alhambra de Granada")
                .descripcion("La Alhambra es una ciudad palatina andalusí situada en Granada. Es uno de los monumentos más visitados de España y una obra maestra del arte islámico.")
                .imagen("https://upload.wikimedia.org/wikipedia/commons/9/9b/Alhambra_de_Granada.jpg")
                .build());

        add(Monumento.builder()
                .id(3L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Barcelona")
                .latitud(41.40363)
                .longitud(2.17435)
                .nombre("Sagrada Familia")
                .descripcion("La Sagrada Familia es una basílica católica diseñada por Antoni Gaudí. Es una de las obras más emblemáticas de la arquitectura modernista catalana.")
                .imagen("https://upload.wikimedia.org/wikipedia/commons/a/af/Sagrada_Familia_2021.jpg")
                .build());

        add(Monumento.builder()
                .id(4L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Sevilla")
                .latitud(37.38333)
                .longitud(-5.99000)
                .nombre("Catedral de Sevilla")
                .descripcion("La Catedral de Sevilla, conocida como Santa María de la Sede, es la catedral gótica más grande del mundo y un importante hito de la ciudad.")
                .imagen("https://upload.wikimedia.org/wikipedia/commons/6/64/Catedral_de_Sevilla.jpg")
                .build());

        add(Monumento.builder()
                .id(5L)
                .codigoPais("ES")
                .nombrePais("España")
                .nombreCiudad("Toledo")
                .latitud(39.86283)
                .longitud(-4.02732)
                .nombre("Alcázar de Toledo")
                .descripcion("El Alcázar de Toledo es una fortificación ubicada en la parte más alta de la ciudad de Toledo. Ha servido como palacio, academia militar y símbolo de resistencia.")
                .imagen("https://upload.wikimedia.org/wikipedia/commons/a/a1/Alcazar_de_Toledo.jpg")
                .build());
    }



    public Monumento add(Monumento monumento) {
        monumentos.put(monumento.getId(), monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable(monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento nuevoMonumento) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCodigoPais(nuevoMonumento.getCodigoPais());
            v.setNombrePais(nuevoMonumento.getNombrePais());
            v.setNombreCiudad(nuevoMonumento.getNombreCiudad());
            v.setLatitud(nuevoMonumento.getLatitud());
            v.setLongitud(nuevoMonumento.getLongitud());
            v.setNombre(nuevoMonumento.getNombre());
            v.setDescripcion(nuevoMonumento.getDescripcion());
            v.setImagen(nuevoMonumento.getImagen());

            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }


}
