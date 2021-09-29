package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;

public interface TourGuideService {

    void addTourGuide(TourGuideModel tourGuide);
    
    TourGuideModel updateTourGuide(TourGuideModel tourGuide);
    TourGuideModel getTourGuideByNoGuide(Long noGuide);
    void deleteTourGuide(TourGuideModel tourGuide);
}
