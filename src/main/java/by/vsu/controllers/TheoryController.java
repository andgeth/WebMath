package by.vsu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheoryController extends BaseController {

    @GetMapping("/theory")
    public String theory() {
        return "theory";
    }

    @GetMapping("/theory-newton")
    public String theoryNewton() {
        return "theory-newton";
    }

    @GetMapping("/theory-chord")
    public String theoryChord() {
        return "theory-chord";
    }

    @GetMapping("/theory-simple-iteration")
    public String theorySimpleIteration() {
        return "theory-simple-iteration";
    }

    @GetMapping("/theory-better-euler")
    public String theoryBetterEuler() {
        return "theory-better-euler";
    }

    @GetMapping("/theory-dichotomy")
    public String theoryDichotomy() {
        return "theory-dichotomy";
    }

    @GetMapping("/theory-system-simple-iteration")
    public String theorySystemSimpleIteration() {
        return "theory-system-simple-iteration";
    }

    @GetMapping("/theory-system-newton")
    public String theorySystemNewton() {
        return "theory-system-newton";
    }

    @GetMapping("/theory-euler")
    public String theoryEuler() {
        return "theory-euler";
    }

    @GetMapping("/theory-euler-cochi")
    public String theoryEulerCochi() {
        return "theory-euler-cochi";
    }

    @GetMapping("/theory-euler-system")
    public String theoryEulerSystem() {
        return "theory-euler-system";
    }

    @GetMapping("/theory-net")
    public String theoryNet() {
        return "theory-net";
    }

    @GetMapping("/theory-runge")
    public String theoryRunge() {
        return "theory-runge";
    }

    @GetMapping("/theory-runge-system")
    public String theoryRungeSystem() {
        return "theory-runge-system";
    }

    @GetMapping("/theory-secant")
    public String theorySecant() {
        return "theory-secant";
    }

    @GetMapping("/theory-shoot")
    public String theoryShoot() {
        return "theory-shoot";
    }

    @GetMapping("/theory-border")
    public String theoryBorder() {
        return "theory-border";
    }

    @GetMapping("/theory-differential")
    public String theoryDifferential() {
        return "theory-differential";
    }

    @GetMapping("/theory-diff-system")
    public String theoryDiffSystem() {
        return "theory-diff-system";
    }

    @GetMapping("/theory-rectangles")
    public String theoryRectangles() {
        return "theory-rectangles";
    }

    @GetMapping("/theory-trapeze")
    public String theoryTrapeze() {
        return "theory-trapeze";
    }

    @GetMapping("/theory-simpson")
    public String theorySimpson() {
        return "theory-simpson";
    }

    @GetMapping("/theory-poly-lagrange")
    public String theoryPolyLagrange() {
        return "theory-poly-lagrange";
    }

    @GetMapping("/theory-poly-newton")
    public String theoryPolyNewton() {
        return "theory-poly-newton";
    }

    @GetMapping("/theory-spline")
    public String theorySpline() {
        return "theory-spline";
    }

}
