
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>
<section id="aa-slider">
    <div class="aa-slider-area">
        <div id="sequence" class="seq">
            <div class="seq-screen">
                <ul class="seq-canvas">
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="${url}/images/slide_1.jpg" alt="Men slide img" />
                        </div>
                        <div class="seq-title">
                            <span data-seq>Giảm giá lên đến 50%</span>                
                            <h2 data-seq>Các loại hạt và Pate</h2>                
                            <p data-seq>Các loại hạt tại của hàng luôn luôn được tuyển chọn,và các mặt hàng luôn đảm bảo chất lượng.</p>
                            <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="${url}/images/slide_2.jpg" alt="Wristwatch slide img" />
                        </div>
                        <div class="seq-title">
                            <span data-seq>Giảm giá lên đến 20%</span>                
                            <h2 data-seq>Đồ chơi cho thú cưng</h2>                
                            <p data-seq>Được sản xuất từ các nguyên liệu đảm bảo và chất lượng.</p>
                            <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
                        </div>
                    </li>
                    <!-- single slide item -->
                    <li>
                        <div class="seq-model">
                            <img data-seq src="${url}/images/slide_3.jpg" alt="Women Jeans slide img" />
                        </div>
                        <div class="seq-title">
                            <span data-seq>Giảm giá lên đến 33%</span>                
                            <h2 data-seq>Sản phẩm chăm sóc sức khỏe</h2>                
                            <p data-seq>Sản phẩm đa dạng, hỗ trợ hầu hết các loại bệnh thú cưng mắc phải.</p>
                            <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
                        </div>
                    </li>
                    <!-- single slide item -->           
                    <li>
                        <div class="seq-model">
                            <img data-seq src="${url}/images/slide_4.jpg" alt="Shoes slide img" />
                        </div>
                        <div class="seq-title">
                            <span data-seq>Giảm giá lên đến 25%</span>                
                            <h2 data-seq>Sữa tắm và sản phẩm ngoài da</h2>                
                            <p data-seq>Là 2 sản phẩm mới của cửa hàng và đảm bảo an toàn về nguồn gốc cũng như chất lượng.</p>
                            <a data-seq href="${pageContext.request.contextPath}/view/client/product" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
                        </div>
                    </li>                   
                </ul>
            </div>
            <!-- slider navigation btn -->
            <fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
                <a type="button" class="seq-prev" aria-label="Previous"><span class="fa fa-angle-left"></span></a>
                <a type="button" class="seq-next" aria-label="Next"><span class="fa fa-angle-right"></span></a>
            </fieldset>
        </div>
    </div>
</section>
