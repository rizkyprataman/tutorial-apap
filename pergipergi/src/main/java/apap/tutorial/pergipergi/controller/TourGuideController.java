package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;


@Controller
public class TourGuideController {
    
    @Qualifier("tourGuideServiceImpl")
    @Autowired
    private TourGuideService tourGuideService;

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/tour-guide/add/{noAgensi}")
    public String addTourGuideFormPage(@PathVariable Long noAgensi, Model model){
        TourGuideModel guide = new TourGuideModel();
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        if(agensi == null){
            return "notexist-agensi-guide";
        }
        guide.setAgensi(agensi);
        model.addAttribute("guide", guide);
        return "form-add-tour-guide";
    }

    @PostMapping("/tour-guide/add")
    public String addTourGuideSubmitPage(
        @ModelAttribute TourGuideModel tourGuide,
        Model model
    ){
        tourGuideService.addTourGuide(tourGuide);
        model.addAttribute("noTourGuide", tourGuide.getNoTourGuide());
        return "add-tour-guide";
    }

        //No dua
        @GetMapping("/tour-guide/update/{noAgensi}/{noGuide}")
        public String updateGuideFormPage(
            @PathVariable Long noAgensi,
            @PathVariable Long noGuide,
            Model model
        ){
            TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
            TourGuideModel guide = tourGuideService.getTourGuideByNoGuide(noGuide);
            if(agensi == null || guide == null){
                return "notexist-agensi-guide";
            }
            LocalTime waktuTutup = agensi.getWaktuBuka();
            LocalTime waktuBuka = agensi.getWaktuTutup();
            LocalTime sekarang = LocalTime.now();
            if(sekarang.compareTo(waktuBuka)>0 || sekarang.compareTo(waktuTutup)<0){
                model.addAttribute("guide", guide);
                model.addAttribute("agensi", guide);
                return "form-update-guide";
            }
            else{
                model.addAttribute("agensi", guide);
                 return "gagal-update-guide";
            }
        }
    
        @PostMapping("/tour-guide/update")
        public String updateGuideSubmitPage(
            @ModelAttribute TourGuideModel guide,
            Model model
        ){
            TourGuideModel updatedGuide = tourGuideService.updateTourGuide(guide);
            model.addAttribute("noGuide", updatedGuide.getNoTourGuide());
            return "update-tour-guide";
        }

        //No 3
        @GetMapping("/tour-guide/delete/{noAgensi}/{noGuide}")
        public String deleteGuideFormPage(
            @PathVariable Long noAgensi,
            @PathVariable Long noGuide,
            Model model
        ){
            TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
            TourGuideModel guide = tourGuideService.getTourGuideByNoGuide(noGuide);
            if(agensi == null || guide == null){
                return "notexist-agensi-guide";
            }
            LocalTime waktuTutup = agensi.getWaktuBuka();
            LocalTime waktuBuka = agensi.getWaktuTutup();
            LocalTime sekarang = LocalTime.now();
            if(sekarang.compareTo(waktuBuka)>0 || sekarang.compareTo(waktuTutup)<0){
                tourGuideService.deleteTourGuide(guide);
                return "delete-guide";
            }
            else{
                model.addAttribute("noGuide", guide.getNoTourGuide());
                 return "gagal-delete-guide";
            }
        }
    
}
