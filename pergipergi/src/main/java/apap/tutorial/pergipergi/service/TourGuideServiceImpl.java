package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TourGuideServiceImpl  implements TourGuideService{
    
    @Autowired
    TourGuideDb tourGuideDb;

    @Override
    public void addTourGuide(TourGuideModel tourGuide) { tourGuideDb.save(tourGuide);}

    @Override
    public TourGuideModel getTourGuideByNoGuide(Long noGuide) {
        Optional<TourGuideModel> guide = tourGuideDb.findByNoTourGuide(noGuide);
        if(guide.isPresent()) return guide.get();
        else return null;
    }

    @Override
    public TourGuideModel updateTourGuide(TourGuideModel tourGuide) {
        tourGuideDb.save(tourGuide);
        return tourGuide;
    }

    @Override
    public void deleteTourGuide(TourGuideModel tourGuide){
        tourGuideDb.delete(tourGuide);
    }
}
