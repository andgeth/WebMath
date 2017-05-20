<%@tag%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"><span class="glyphicon glyphicon-home"></span> Главная </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                    aria-haspopup="true" aria-expanded="false">Нелинейные уравнения <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="newton.html">Метод Ньютона</a></li>
                        <li><a href="dichotomy.html"><span>Метод дихотомии</span></a></li>
                        <li><a href="secant.html"><span>Метод секущих</span></a></li>
                        <li><a href="simpleiteration.html"><span>Метод простых итераций</span></a></li>
                        <li><a href="chord.html"><span>Метод хорд</span></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">Системы нелинейные уравнений
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="systemNewtonStart.html">Метод Ньютона</a></li>
                        <li><a href="systemSimpleIterationStart.html"><span>Метод простых итераций</span></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                        aria-haspopup="true" aria-expanded="false">Дифференциальные уравнения
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="euler.html"><span>Метод Эйлера</span></a></li>
                        <li><a href="betterEuler.html"><span>Метод Эйлера(усоверш.)</span></a></li>
                        <li><a href="eulerCochi.html"><span>Метод Эйлера-Коши</span></a></li>
                        <li><a href="rungeKutta.html"><span>Метод Рунге-Кутта</span></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                        aria-haspopup="true" aria-expanded="false">Системы дифференциальных уравнений
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="eulerSystem.html"><span>Метод Эйлера</span></a></li>
                        <li><a href="rungeKuttaSystem.html"><span>Метод Рунге-Кутта</span></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">Методы численного интегрирования
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="rectanglesMethod.html"><span>Метод прямоугольников</span></a></li>
                        <li><a href="trapezeMethod.html"><span>Метод трапеций</span></a></li>
                        <li><a href="simpsonMethod.html"><span>Метод Симпсона</span></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">Интерполяция функций
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="polyLagrange.html"><span>Многочлен Лагранжа</span></a></li>
                        <li><a href="polyNewton.html"><span>Многочлен Ньютона</span></a></li>
                        <li><a href="spline.html"><span>Интерполяция сплайнами</span></a></li>
                    </ul>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="help.html">Помощь </a></li>
                <li class="about"><a href="about.html">О нас</a></li>
            </ul>
        </div>
    </div>
</nav>