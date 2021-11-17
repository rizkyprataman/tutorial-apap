package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import apap.tutorial.pergipergi.rest.TourGuideDetail;
import apap.tutorial.pergipergi.rest.setting;

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
public class TourGuideRestServiceImpl implements TourGuideRestService {
    private final WebClient webClient;
    
    @Autowired
    private TourGuideDb tourGuideDb;


    public TourGuideRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(setting.guideUrl).build();
    }

    @Override
    public TourGuideModel getUmur(Long noTourGuide){
         Optional<TourGuideModel> guide = tourGuideDb.findByNoTourGuide(noTourGuide);
         String namaGuide = "";
         TourGuideModel tourguide = null;
        if(guide.isPresent()){
            tourguide = guide.get();
            namaGuide = tourguide.getNamaTourGuide().split(" ")[0];
        }

        Mono<TourGuideDetail> result = this.webClient.get().uri("?name=" + namaGuide).retrieve().bodyToMono(TourGuideDetail.class);
        Integer umur = result.block().getAge();
        tourguide.setUmur(umur);
        tourGuideDb.save(tourguide);
        return tourguide;


    }
}
