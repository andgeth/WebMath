package by.vsu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheoryController
{

    @RequestMapping("/theory")
    public String theory()
    {
        return "theory";
    }

    @RequestMapping("/theoryNewton")
    public String theoryNewton(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryNewton";
    }

    @RequestMapping("/theoryChord")
    public String theoryChord(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryChord";
    }

    @RequestMapping("/theorySimpleiteration")
    public String theorySimpleiteration(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySimpleiteration";
    }

    @RequestMapping("/theoryBetterEuler")
    public String theoryBetterEuler(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryBetterEuler";
    }

    @RequestMapping("/theoryDichotomy")
    public String theoryDichotomy()
    {
        return "theoryDichotomy";
    }

    @RequestMapping("/theorySystemSimpleIteration")
    public String theorySystemSimpleIteration(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySystemSimpleIteration";
    }

    @RequestMapping("/theorySystemNewton")
    public String theorySystemNewton(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySystemNewton";
    }

    @RequestMapping("/theoryEuler")
    public String theoryEuler(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryEuler";
    }

    @RequestMapping("/theoryEulerCochi")
    public String theoryEulerCochi(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryEulerCochi";
    }

    @RequestMapping("/theoryEulerSystem")
    public String theoryEulerSystem(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryEulerSystem";
    }

    @RequestMapping("/theoryNet")
    public String theoryNet(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryNet";
    }

    @RequestMapping("/theoryRunge")
    public String theoryRunge(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryRunge";
    }

    @RequestMapping("/theoryRungeSystem")
    public String theoryRungeSystem(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryRungeSystem";
    }

    @RequestMapping("/theorySecant")
    public String theorySecant(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySecant";
    }

    @RequestMapping("/theoryShoot")
    public String theoryShoot(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryShoot";
    }

    @RequestMapping("/theoryBorder")
    public String theoryBorder(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryBorder";
    }

    @RequestMapping("/theoryDiff")
    public String theoryDiff(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryDiff";
    }

    @RequestMapping("/theoryDiffSystem")
    public String theoryDiffSystem(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryDiffSystem";
    }

    @RequestMapping("/theoryUnlinear")
    public String theoryUnlinear(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryUnlinear";
    }

    @RequestMapping("/theoryRectanglesMethod")
    public String theoryRectanglesMethod(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryRectanglesMethod";
    }

    @RequestMapping("/theoryTrapezeMethod")
    public String theoryTrapezeMethod(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryTrapezeMethod";
    }

    @RequestMapping("/theorySimpsonMethod")
    public String theorySimpsonMethod(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySimpsonMethod";
    }

    @RequestMapping("/theoryPolyLagrange")
    public String theoryPolyLagrange(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryPolyLagrange";
    }

    @RequestMapping("/theoryPolyNewton")
    public String theoryPolyNewton(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theoryPolyNewton";
    }

    @RequestMapping("/theorySpline")
    public String theorySpline(Model model)
    {
        model.addAttribute("index", false);
        model.addAttribute("theory", true);
        model.addAttribute("about", false);
        return "theorySpline";
    }
}
