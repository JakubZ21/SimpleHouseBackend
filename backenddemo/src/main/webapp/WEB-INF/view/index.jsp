
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Simple House Template</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/css/templatemo-style.css" rel="stylesheet" type="text/css"/>
</head>
<!--

Simple House

https://templatemo.com/tm-539-simple-house

-->
<body> 
	${pageContext.request.contextPath}
	<div class="container">
	<!-- Top box -->
		<!-- Logo & Site Name -->
		<div class="placeholder">
			<div class="parallax-window" data-parallax="scroll" data-image-src="${pageContext.request.contextPath}/resources/img/simple-house-01.jpg">
				<div class="tm-header">
					<div class="row tm-header-inner">
						<div class="col-md-6 col-12">
							<img src="${pageContext.request.contextPath}/resources/img/simple-house-logo.png" alt="Logo" class="tm-site-logo" />
							<div class="tm-site-text-box">
								<h1 class="tm-site-title">Simple House</h1>
								<h6 class="tm-site-description">new restaurant template</h6>	
							</div>
						</div>
						<nav class="col-md-6 col-12 tm-nav">
							<ul class="tm-nav-ul">
								<li class="tm-nav-li"><a href="" class="tm-nav-link active">Home</a></li>
								<li class="tm-nav-li"><a href="${pageContext.request.contextPath}/about" class="tm-nav-link">About</a></li>
								<li class="tm-nav-li"><a href="${pageContext.request.contextPath}/contact" class="tm-nav-link">Contact</a></li>
								<sec:authorize access="isAuthenticated()">
								<li class="tm-nav-li"><form:form id="logout_form" method="post" action="${pageContext.request.contextPath}/logout">
										<a class="tm-nav-link" style="cursor: pointer" onclick="document.getElementById('logout_form').submit()">Logout</a>
									</form:form></li>
								</sec:authorize>
							</ul>
						</nav>	
					</div>
				</div>
			</div>
		</div>

		<main>
			<header class="row tm-welcome-section">
				<h2 class="col-12 text-center tm-section-title">Welcome to Simple House</h2>
				<p class="col-12 text-center">Total 3 HTML pages are included in this template. Header image has a parallax effect. You can feel free to download, edit and use this TemplateMo layout for your commercial or non-commercial websites.</p>
			</header>
			
			<div class="tm-paging-links">
				<nav>
					<ul>
							<li class="tm-paging-item"><a href="${pageContext.request.contextPath}/" class="
									<c:choose>
									    <c:when test="${param['categoryId']==null}">tm-paging-link active</c:when>
										<c:otherwise>tm-paging-link</c:otherwise>
									</c:choose>">All</a>
							</li>
						<c:forEach var="category" items="${categories}">
							<li class="tm-paging-item">
								<a href="?categoryId=${category.id}"
								   class="<c:choose>
									    <c:when test="${category.id == param['categoryId']}">tm-paging-link active</c:when>
										<c:otherwise>tm-paging-link</c:otherwise>
									</c:choose>"
								>${category.category}
								</a>
							</li>
						</c:forEach>
						<sec:authorize access="isAuthenticated()">
						<li class="tm-paging-item">
						<a class="tm-paging-link" href="${pageContext.request.contextPath}/meals/categoryForm">Add Category</a>
						</li>
						</sec:authorize>
					</ul>
				</nav>
			</div>
			<!-- Gallery -->
			<div class="row tm-gallery">
				<!-- gallery page 1 -->
				<div class="tm-gallery-page">
					<!--TODO Prices showing as 31.0 instead of 31-->
					<c:forEach var="meal" items="${meals}">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>
								<img src="${pageContext.request.contextPath}/resources/img/gallery/${meal.imgUrl}" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">${meal.mealName}</h4>
									<p class="tm-gallery-description">${meal.mealDesc}</p>
									<p class="tm-gallery-price">$${meal.mealPrice}
										<!--TODO Change styles and make the buttons nice-->
										<sec:authorize access="hasAnyRole('MANAGER','ADMIN')">
										<a href="meals/deleteMeal?mealId=${meal.mealId}" onclick="if(!(confirm('Are you sure you want to delete that meal?'))) return false" class="tm-btn-danger" style="border-radius: 5px">X</a>
										<a href="${pageContext.request.contextPath}/meals/mealUpdateForm?mealId=${meal.mealId}" class="tm-btn-default" style="border-radius: 5px">Update</a></sec:authorize></p>

								</figcaption>
							</figure>
						</article>
					</c:forEach>
					<sec:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<a href="<c:url value="/meals/mealForm"/>" style="text-underline: none; text-decoration: none;">
								<figure>

									<img src="${pageContext.request.contextPath}/resources/img/gallery/addNew.jpg" alt="Image" class="img-fluid tm-gallery-img" />
									<figcaption>
										<h4 class="tm-gallery-title">Add new meal</h4>
										<p class="tm-gallery-description"></p>
										<p class="tm-gallery-price"></p>
									</figcaption>
								</figure>
							</a>
						</article>
					</sec:authorize>


				</div> <!-- gallery page 1 -->
			</div>
			<div class="tm-section tm-container-inner">
				<div class="row">
					<div class="col-md-6">
						<figure class="tm-description-figure">
							<img src="${pageContext.request.contextPath}/resources/img/img-01.jpg" alt="Image" class="img-fluid" />
						</figure>
					</div>
					<div class="col-md-6">
						<div class="tm-description-box"> 
							<h4 class="tm-gallery-title">Maecenas nulla neque</h4>
							<p class="tm-mb-45">Redistributing this template as a downloadable ZIP file on any template collection site is strictly prohibited. You will need to <a rel="nofollow" href="https://templatemo.com/contact">talk to us</a> for additional permissions about our templates. Thank you.</p>
							<a href="about" class="tm-btn tm-btn-default tm-right">Read More</a>
						</div>
					</div>
				</div>
			</div>
		</main>

		<footer class="tm-footer text-center">
			<p>Copyright &copy; 2020 Simple House 
            
            | Design: <a rel="nofollow" href="https://templatemo.com">TemplateMo</a></p>
		</footer>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/parallax.min.js"></script>
</body>
</html>