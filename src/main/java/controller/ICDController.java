package controller;

import java.util.List;
import model.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ICDService;

@RestController
@RequestMapping(
        path = {"/"}
)
public class ICDController {
    @Autowired
    private ICDService icdService;

    @RequestMapping(
            path = {"icds"},
            method = {RequestMethod.GET}
    )
    public List<Disease> getICDs() {
        return this.icdService.getICDs();
    }

}
