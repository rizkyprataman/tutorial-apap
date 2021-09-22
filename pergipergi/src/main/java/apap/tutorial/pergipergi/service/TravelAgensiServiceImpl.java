package apap.tutorial.pergipergi.service;

import org.springframework.stereotype.Service;

import apap.tutorial.pergipergi.model.TravelAgensiModel;

import java.util.*;
@Service
public class TravelAgensiServiceImpl implements TravelAgensiService {
    private List<TravelAgensiModel> listAgensi;

    public TravelAgensiServiceImpl(){
        listAgensi = new ArrayList<>();
    }

    @Override
    public void addAgensi(TravelAgensiModel travelAgensiModel){
        listAgensi.add(travelAgensiModel);
    }

    @Override
    public List<TravelAgensiModel> getListAgensi(){
        return listAgensi;
    }

    @Override
    public TravelAgensiModel getAgensiByidAgensi(String idAgensi){
        for(TravelAgensiModel agen: listAgensi){
            if(agen.getIdAgensi().equals(idAgensi)){
                return agen;
            }
        }
        return null;
    }

    @Override
    public void deleteAgensi(TravelAgensiModel travelAgensi){
        listAgensi.remove(travelAgensi);
    }
}
