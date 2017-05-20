<%@tag%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebNATS</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/cover.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/TG.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/normalize.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/pushy.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>">

        <style type="text/css">
            .nav>li>a, .nav>li>a:focus, .nav>li>a:hover {
                background-color: transparent;
                text-decoration: underline;
                text-shadow: none;
                font-size: 18px;
            }

            .nav>li>a {
                background-color: transparent;
                text-decoration: none;
                text-shadow: none;
                font-size: 14px;
            }
        </style>
    </head>

    <body style="background: url(${contextPath}/resources/css/background.jpg) no-repeat">
        <div class="site-wrapper">
            <div class="site-wrapper-inner">
                <div class="content" style="height: 90%;">
                    <div class="container-fluid">
                        <div id="logo" class="row" style="background: url(${contextPath}/resources/css/logo.jpg) no-repeat;">
                            <ul class="nav navbar-nav pull-right">
                                <li><a href="index">Главная</a></li>
                                <li><a href="theory">Теория</a></li>
                                <li><a href="help">Справка</a></li>
                                <li><a href="about">О нас</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="sidebar">
                                    <ul class="drop-menu-main">
                                        <li><span class="drop-down">Нелинейные уравнения</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="newton">Метод Ньютона</a>
                                                <a href="dichotomy">Метод дихотомии</a>
                                                <a href="secant">Метод секущих</a>
                                                <a href="chord">Метод хорд</a>
                                                <a href="simple-iteration">Метод простых итераций</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>

                                        <li><span class="drop-down">Системы нелинейных уравнений</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="system-newton">Метод Ньютона</a>
                                                <a href="system-simple-iteration">Метод простых итераций</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Дифференциальные уравнения</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="euler">Метод Эйлера</a>
                                                <a href="better-euler">Усоверш. метод Эйлера</a>
                                                <a href="euler-cauchy">Метод Эйлера-Коши</a>
                                                <a href="runge-kutta">Метод Рунге-Кутта</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Системы дифференциальные уравнения</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="euler-system">Метод Эйлера</a>
                                                <a href="runge-kutta-system">Метод Рунге-Кутты</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Интерполирование функций</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="poly-lagrange">Многочлен Лагранжа</a>
                                                <a href="poly-newton">Многочлен Ньютона</a>
                                                <a href="spline">Интерполяционный сплайн</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Численное интегрирование</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="rectangles">Метод прямоугольников</a>
                                                <a href="trapeze">Метод трапеций</a>
                                                <a href="simpson">Метод Симпсона</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Методы решения краевых задач</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="nets">Метод сеток</a>
                                                <a href="reduction">Метод редукции</a>
                                                <a href="shoot">Метод стрельбы</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li><span class="drop-down">Численные методы математической физики</span>
                                            <div class="drop-menu-main-sub">
                                                <span class="title"></span>
                                                <a href="parabolic-eq">Параболические уравнения</a>
                                                <a href="hyperbolic-eq">Гиперболические уравнения</a>
                                                <a href="elliptic-eq">Эллиптические уравнения</a>
                                            </div>
                                            <span class="arrow">&#9658;</span>
                                        </li>
                                        <li>
                                            <span><a href="divide">Отделение корней</a></span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <jsp:doBody />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer">
                    <hr><footer>VSU 2017</footer>
                </div>
            </div>

        </div>

        <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
        <script language="javascript" type="text/javascript" src="${contextPath}/resources/js/jquery.flot.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                function hideallDropdowns() {
                    $(".dropped .drop-menu-main-sub").hide();
                    $(".dropped").removeClass('dropped');
                    $(".dropped .drop-menu-main-sub .title").unbind("click");
                }

                function showDropdown(el)
                {
                    var el_li = $(el).parent().addClass('dropped');
                    el_li.find('.drop-menu-main-sub').show();
                }

                $(".drop-down").click(function(){
                    showDropdown(this);
                });

                $(document).mouseup(function () {
                    hideallDropdowns();
                });
            });
        </script>

    </body>
</html>