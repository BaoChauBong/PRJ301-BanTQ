
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LittlePET - Error</title>
        <c:import url="component/head.jspf"/>
    </head>

    <body>
        <div class="page-header align-items-start min-vh-100" style="background-image: url('https://1.bp.blogspot.com/-hN0NCoAmEDY/X8z1OcRjXmI/AAAAAAAAlc0/hHqbHzqOPhIABiVomzpYacPeEufV816QQCNcBGAsYHQ/w350-h265-p-k-no-nu/hinh-nen-may-cuc-dep.jpg');" loading="lazy">
            <span class="mask bg-gradient-dark opacity-6"></span>
            <div class="container my-auto">
                <div class="row">
                    <div class="col-lg-8 col-md-10 col-12 mx-auto text-center">
                        <h2 style="color: #ff6b6b;">${requestScope.LOGIN_ERROR}</h2>
                    </div>
                </div>
            </div>
            <c:import url="component/header.jspf"/>
            <c:import url="component/footer.jspf"/>
        </div>

        <c:import url="component/scripts.jspf"/>
    </body>
</html>
