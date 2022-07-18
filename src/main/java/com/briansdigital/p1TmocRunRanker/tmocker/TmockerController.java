package com.briansdigital.p1TmocRunRanker.tmocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="")
public class TmockerController {

    private final TmockerService tmockerService;

    @Autowired
    public TmockerController(TmockerService tmockerService) {
        this.tmockerService = tmockerService;
    }

    @GetMapping
    public List<Tmocker> getTmockers() {
        return tmockerService.getTmockers();
    }
    @PostMapping
    public void registerNewTmocker(@RequestBody Tmocker tmocker) {
        tmockerService.addNewTmocker(tmocker);
    }

    @DeleteMapping(path="{tmockerId}")
    public void deleteTmocker(@PathVariable("tmockerId") Long tmockerId) {
        tmockerService.deleteTmocker(tmockerId);
        }

        @PutMapping(path="{tmockerId}")
        public void updateTmocker(
                    @PathVariable("tmockerId") Long tmockerId,
                    @RequestParam(required = false) String name,
                    @RequestParam(required = false) String email) {
            tmockerService.updateTmocker(tmockerId, name, email);
        }
}
