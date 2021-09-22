package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;

import java.util.List;

import javax.validation.constraints.Null;

@Controller
public class TravelAgensiController {

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/agensi/add")
    public String addAgensiFormPage(Model model){
        model.addAttribute("agensi", new TravelAgensiModel());
        return "form-add-agensi";
    }

    @PostMapping("/agensi/add")
    public String addAgensiSubmitPage(
        @ModelAttribute TravelAgensiModel agensi,
        Model model
    ){
        travelAgensiService.addAgensi(agensi);
        model.addAttribute("noAgensi", agensi.getNoAgensi());
        return "add-agensi";
    }

    @GetMapping("/agensi/viewall")
    public String listAgensi(Model model){
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
        model.addAttribute("listAgensi", listAgensi);
        return "viewall-agensi";
    }

    @GetMapping("/agensi/view")
    public String viewDetailAgensiPage(
        @RequestParam(value = "noAgensi") Long noAgensi,
        Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        if(agensi!=null){
            List<TourGuideModel> listTourGuide = agensi.getListTourGuide();
            model.addAttribute("agensi", agensi);
            model.addAttribute("listTourGuide", listTourGuide);
            return "view-agensi";
        }
        return "notexist-agensi-guide";
    }

    @GetMapping("/agensi/update/{noAgensi}")
    public String updateAgensiFormPage(
        @PathVariable Long noAgensi,
        Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        if(agensi != null){
            model.addAttribute("agensi", agensi);
            return "form-update-agensi";
        }
        return "notexist-agensi-guide";
        
    }

    @PostMapping("/agensi/update")
    public String updateAgensiSubmitPage(
        @ModelAttribute TravelAgensiModel agensi,
        Model model
    ){
        TravelAgensiModel updatedAgensi = travelAgensiService.updateAgensi(agensi);
        model.addAttribute("noAgensi", updatedAgensi.getNoAgensi());
        return "update-agensi";
    }

    @GetMapping("/agensi/viewallAsc")
    public String listAgensiAsc(Model model){
        List<TravelAgensiModel> listAgensiAsc = travelAgensiService.getListAgensiOrderedAsc();
        model.addAttribute("listAgensi", listAgensiAsc);
        return "viewall-agensi";
    }

    //no 4
    @GetMapping("/agensi/delete/{noAgensi}")
    public String deleteGuideFormPage(
        @PathVariable Long noAgensi,
        Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        if(agensi == null){
            return "notexist-agensi-guide";
        }
        LocalTime waktuTutup = agensi.getWaktuBuka();
        LocalTime waktuBuka = agensi.getWaktuTutup();
        LocalTime sekarang = LocalTime.now();
        int banyakTourGuide = agensi.getListTourGuide().size();
        if((sekarang.compareTo(waktuBuka)>0 || sekarang.compareTo(waktuTutup)<0) && (banyakTourGuide == 0)){
            travelAgensiService.deleteAgensi(agensi);
            model.addAttribute("noAgensi", noAgensi);
            return "delete-agensi";
        }
        else{
            model.addAttribute("noAgensi", noAgensi);
             return "gagal-delete-agensi";
        }
    }
}
