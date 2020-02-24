
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Simple House Template</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
								<li class="tm-nav-li"><a href="home" class="tm-nav-link active">Home</a></li>
								<li class="tm-nav-li"><a href="about" class="tm-nav-link">About</a></li>
								<li class="tm-nav-li"><a href="contact" class="tm-nav-link">Contact</a></li>
								<!--TODO Add login page-->
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
						<li class="tm-paging-item"><a href="#" class="tm-paging-link active">Pizza</a></li>
						<li class="tm-paging-item"><a href="#" class="tm-paging-link">Salad</a></li>
						<li class="tm-paging-item"><a href="#" class="tm-paging-link">Noodle</a></li>
					</ul>
				</nav>
			</div>
			<!-- TODO Make this with hibernate DB-->
			<!-- Gallery -->
			<div class="row tm-gallery">
				<!-- gallery page 1 -->
				<div id="tm-gallery-page-pizza" class="tm-gallery-page">
					<c:forEach var="meal" items="${meals}">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>
								<img src="${pageContext.request.contextPath}/resources/img/gallery/${meal.imgUrl}" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">${meal.mealName}</h4>
									<p class="tm-gallery-description">${meal.mealDesc}</p>
									<p class="tm-gallery-price">$${meal.mealPrice}<a href="meals/deleteMeal?mealId=${meal.mealId}" onclick="if(!(confirm('Are you sure you want to delete that meal?'))) return false" class="btn btn-danger btn-sm">X</a></p>

								</figcaption>
							</figure>
						</article>
					</c:forEach>
					<a href="<c:url value="meals/addNewMeal"/>">
					<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
						<figure>

							<img src="${pageContext.request.contextPath}/resources/img/gallery/addNew.jpg" alt="Image" class="img-fluid tm-gallery-img" />
							<figcaption>
								<h4 class="tm-gallery-title">Add new meal</h4>
								<p class="tm-gallery-description"></p>
								<p class="tm-gallery-price"></p>
							</figcaption>
						</figure>
					</article>
					</a>

				</div> <!-- gallery page 1 -->
				
				<!-- gallery page 2 -->
				<div id="tm-gallery-page-salad" class="tm-gallery-page hidden">
					<c:forEach var="meal" items="${meals}">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>
								<img src="${pageContext.request.contextPath}/resources/img/gallery/${meal.imgUrl}" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">${meal.mealName}</h4>
									<p class="tm-gallery-description">${meal.mealDesc}</p>
									<p class="tm-gallery-price">$${meal.mealPrice}</p>
								</figcaption>
							</figure>
						</article>
					</c:forEach>
					<a href="<c:url value="/meals/addNewMeal"/>">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>

								<img src="${pageContext.request.contextPath}/resources/img/gallery/addNew.jpg" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">Add new meal</h4>
									<p class="tm-gallery-description"></p>
									<p class="tm-gallery-price"></p>
								</figcaption>
							</figure>
						</article>
					</a>
				</div> <!-- gallery page 2 -->
				
				<!-- gallery page 3 -->
				<div id="tm-gallery-page-noodle" class="tm-gallery-page hidden">
					<c:forEach var="meal" items="${meals}">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>
								<img src="${pageContext.request.contextPath}/resources/img/gallery/${meal.imgUrl}" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">${meal.mealName}</h4>
									<p class="tm-gallery-description">${meal.mealDesc}</p>
									<p class="tm-gallery-price">$${meal.mealPrice}</p>
								</figcaption>
							</figure>
						</article>
					</c:forEach>
					<a href="<c:url value="meals/addNewMeal"/>">
						<article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
							<figure>

								<img src="${pageContext.request.contextPath}/resources/img/gallery/addNew.jpg" alt="Image" class="img-fluid tm-gallery-img" />
								<figcaption>
									<h4 class="tm-gallery-title">Add new meal</h4>
									<p class="tm-gallery-description"></p>
									<p class="tm-gallery-price"></p>
								</figcaption>
							</figure>
						</article>
					</a>

				</div> <!-- gallery page 3 -->
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
	<script>
		$(document).ready(function(){
			// Handle click on paging links
			$('.tm-paging-link').click(function(e){
				e.preventDefault();

				var page = $(this).text().toLowerCase();
				$('.tm-gallery-page').addClass('hidden');
				$('#tm-gallery-page-' + page).removeClass('hidden');
				$('.tm-paging-link').removeClass('active');
				$(this).addClass("active");
			});
		});
	</script>
</body>
</html>