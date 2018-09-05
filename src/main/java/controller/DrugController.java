package controller;

import java.util.List;
import java.util.Map;
import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.DrugService;
import service.PrescriptionService;

@RestController
@RequestMapping(
        path = {"/"}
)
public class DrugController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private PrescriptionService prescriptionService;

    public DrugController() {
    }

    @RequestMapping(
            path = {"drugs"},
            method = {RequestMethod.POST}
    )
    public int addDrug(@RequestBody Drug drug) {
        return this.drugService.addDrug(drug);
    }

    @RequestMapping(
            path = {"drugs"},
            method = {RequestMethod.GET}
    )
    public List<Drug> getAllDrugs() {
        return this.drugService.getAllDrugs();
    }

    @RequestMapping(
            path = {"drugs/{id}"},
            method = {RequestMethod.GET}
    )
    public Drug getDrug(@PathVariable int id) {
        return this.drugService.getDrug(id);
    }

    @RequestMapping(
            path = {"drugs"},
            method = {RequestMethod.PUT}
    )
    public void updateDrug(@RequestBody Drug drug) {
        this.drugService.updateDrug(drug);
    }

    @RequestMapping(
            path = {"drugs/{id}"},
            method = {RequestMethod.DELETE}
    )
    public void deleteDrug(@PathVariable int id) {
        this.drugService.deleteDrug(id);
    }

//    @RequestMapping(
//            path = {"drugsPrescribed"},
//            method = {RequestMethod.GET}
//    )
//    public Map<Drug, Integer> getDrugs() {
//        return this.prescriptionService.getDrugCounts();
//    }
}
