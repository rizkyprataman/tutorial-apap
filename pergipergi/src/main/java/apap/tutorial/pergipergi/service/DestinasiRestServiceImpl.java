package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.DestinasiModel;
import apap.tutorial.pergipergi.repository.DestinasiDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional
public class DestinasiRestServiceImpl implements DestinasiRestService{

    @Autowired
    private DestinasiDB destinasiDB;

    @Override
    public DestinasiModel createDestinasi(DestinasiModel destinasi) {return destinasiDB.save(destinasi);}

    @Override
    public List<DestinasiModel> retrieveListDestinasi() {return destinasiDB.findAll();}

    @Override
    public DestinasiModel getDestinasiByNoDestinasi(Long noDestinasi){
        Optional<DestinasiModel> destinasi = destinasiDB.findByNoDestinasi(noDestinasi);
        if(destinasi.isPresent()){
            return destinasi.get();
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public DestinasiModel updateDestinasi(Long noDestinasi, DestinasiModel destinasiUpdate){
        DestinasiModel destinasi = getDestinasiByNoDestinasi(noDestinasi);
        destinasi.setNegaraDestinasi(destinasiUpdate.getNegaraDestinasi());
        destinasi.setIsBebasVisa(destinasi.getIsBebasVisa());
        return destinasiDB.save(destinasi);
    }

    @Override
    public  void deleteDestinasi(long noDestinasi){
        DestinasiModel destinasi = getDestinasiByNoDestinasi(noDestinasi);
        destinasiDB.delete(destinasi);
    }
}

