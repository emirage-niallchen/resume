/*===================================
Author       : Bestwebcreator.
Template Name: Martyn CV - Resume / CV / Portfolio & vCard HTML5 Template
Version      : 1.0
更多精品模板：http://www.bootstrapmb.com
===================================*/

/*===================================*
PAGE JS
*===================================*/

(function($) {
	'use strict';
	
	/*===================================*
	01. LOADING JS
	/*===================================*/
	$(window).on('load', function() {
		var preLoder = $(".preloader");
		preLoder.delay(700).fadeOut(500);
	});

	/*===================================*
	02. SMOOTH SCROLLING JS
	*===================================*/
	// Select all links with hashes
	var headerHeight = $(".header_wrap:not('.sidebar_menu')").height() - 10;
    $('a.page-scroll').on('click', function(event) {
        // On-page links
        if ( location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') && location.hostname === this.hostname ) {
          // Figure out element to scroll to
          var target = $(this.hash),
              speed= $(this).data("speed") || 800;
              target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');

          // Does a scroll target exist?
          if (target.length) {
            // Only prevent default if animation is actually gonna happen
            event.preventDefault();
            $('html, body').animate({
              scrollTop: target.offset().top - headerHeight
            }, speed);
          }
        }
    });
	
	/*===================================*
	03. MENU JS
	*===================================*/
	//Main navigation scroll spy for shadow
	$(window).on('scroll', function() {
		var scroll = $(window).scrollTop();

	    if (scroll >= 80) {
	        $('header').addClass('nav-fixed');
	    } else {
	        $('header').removeClass('nav-fixed');
	    }

	});
	
	//Show Hide dropdown-menu Main navigation 
	$( document ).on('ready', function () {
		$( '.dropdown-menu a.dropdown-toggler' ).on( 'click', function () {
			if ( !$( this ).next().hasClass( 'show' ) ) {
				$( this ).parents( '.dropdown-menu' ).first().find( '.show' ).removeClass( "show" );
			}
			var $subMenu = $( this ).next( ".dropdown-menu" );
			$subMenu.toggleClass( 'show' );
			
			$( this ).parent( "li" ).toggleClass( 'show' );
	
			$( this ).parents( 'li.nav-item.dropdown.show' ).on( 'hidden.bs.dropdown', function () {
				$( '.dropdown-menu .show' ).removeClass( "show" );
			} );
			
			return false;
		});
	});
	
	//Hide Navbar Dropdown After Click On Links
	var navBar = $(".header_wrap");
	var navbarLinks = navBar.find(".navbar-collapse ul li a.page-scroll");

    $.each( navbarLinks, function() {

      var navbarLink = $(this);

        navbarLink.on('click', function () {
          navBar.find(".navbar-collapse").collapse('hide');
		  $("header").removeClass("active");
        });

    });
	
	//Main navigation Active Class Add Remove
	$('.navbar-toggler').on('click', function() {
		$("header").toggleClass("active");
	});	
	
	//Scroll Js
	if ($(window).width() >= 992) {
		if ($('.header_wrap.sidebar_menu,.portfolio_modal .modal-content').length > 0) { 
			$(".header_wrap.sidebar_menu,.portfolio_modal .modal-content").mCustomScrollbar({
				theme:"dark"
			});
		}
	}
	else {
		if ($('.header_wrap .navbar-collapse, .portfolio_modal .modal-content').length > 0) { 
			$(".header_wrap .navbar-collapse, .portfolio_modal .modal-content").mCustomScrollbar({
				theme:"dark"
			});
		}
	}
	
	/*===================================*
	04. SLIDER JS
	*===================================*/
		var owl = $('.owl-thumbs-slider');
		owl.owlCarousel({
			loop: false,
			items: 4,
			dots: false,
			margin: 10,
			nav: true,
			thumbs: true,
			navText: ['<i class="ion-ios-arrow-back"></i>', '<i class="ion-ios-arrow-forward"></i>'],
		});
		 
		$( window ).on( "load", function() {
			$('.carousel_slider').each( function() {
				var $carousel = $(this);
				$carousel.owlCarousel({
					dots : $carousel.data("dots"),
					loop : $carousel.data("loop"),
					items: $carousel.data("items"),
					margin: $carousel.data("margin"),
					mouseDrag: $carousel.data("mouse-drag"),
					touchDrag: $carousel.data("touch-drag"),
					autoHeight: $carousel.data("autoheight"),
					center: $carousel.data("center"),
					nav: $carousel.data("nav"),
					rewind: $carousel.data("rewind"),
					navText: ['<i class="ion-ios-arrow-back"></i>', '<i class="ion-ios-arrow-forward"></i>'],
					autoplay : $carousel.data("autoplay"),
					animateIn : $carousel.data("animate-in"),
					animateOut: $carousel.data("animate-out"),
					autoplayTimeout : $carousel.data("autoplay-timeout"),
					smartSpeed: $carousel.data("smart-speed"),
					responsive: $carousel.data("responsive")
				});	
				
			});
		});
	
	/*===================================*
	05. PORTFOLIO JS
	*===================================*/
	$( window ).on( "load", function() {
		var $grid_selectors  = $(".grid_container");
		var filter_selectors = ".grid_filter > li > a";
		$(document).ready(function() {
			if( $grid_selectors.length > 0 ) {
				$grid_selectors.imagesLoaded(function(){
					if ($grid_selectors.hasClass("masonry")){
						$grid_selectors.isotope({
							itemSelector: '.grid_item',
							percentPosition: true,
							layoutMode: "masonry",
							masonry: {
								columnWidth: '.grid-sizer'
							},
						});
					} 
					else {
						$grid_selectors.isotope({
							itemSelector: '.grid_item',
							percentPosition: true,
							layoutMode: "fitRows",
						});
					}
				});
			}
		});
	
		//isotope filter
		$(document).on( "click", filter_selectors, function() {
			$(filter_selectors).removeClass("current");
			$(this).addClass("current");
			var dfselector = $(this).data('filter');
			if ($grid_selectors.hasClass("masonry")){
				$grid_selectors.isotope({
					itemSelector: '.grid_item',
					layoutMode: "masonry",
					masonry: {
						columnWidth: '.grid_item'
					},
					filter: dfselector
				});
			} 
			else {
				$grid_selectors.isotope({
					itemSelector: '.grid_item',
					layoutMode: "fitRows",
					filter: dfselector
				});
			}
			return false;
		});

		$(window).on("resize", function () {
			setTimeout(function () {
				$grid_selectors.find('.grid_item').removeClass('animation').removeClass('animated'); // avoid problem to filter after window resize
				$grid_selectors.isotope('layout');
			}, 300);
		});
	});
	
	$('.grid_item .image_popup').on('click', function () {
		$(this).find('.link_container').magnificPopup('open');
	});
	$('.link_container').each(function () {
		$(this).magnificPopup({
			delegate: '.image_popup',
			type: 'image',
			gallery: {
				enabled: true
			}
		});
	});
	
	/*===================================*
	06. CONTACT FORM JS
	*===================================*/
	$("#submitButton").on("click", function(event) {
	    event.preventDefault();
	    var mydata = $("form").serialize();
	    $.ajax({
	        type: "POST",
	        dataType: "json",
	        url: "contact.php",
	        data: mydata,
	        success: function(data) {
	            if (data.type === "error") {
	                $("#alert-msg").removeClass("alert-msg-success");
	                $("#alert-msg").addClass("alert-msg-failure");
	            } else {
	                $("#alert-msg").addClass("alert-msg-success");
	                $("#alert-msg").removeClass("alert-msg-failure");
	                $("#first-name").val("Enter Name");
	                $("#email").val("Enter Email");
	                $("#subject").val("Enter Subject");
	                $("#description").val("Enter Message");

	            }
	            $("#alert-msg").html(data.msg);
	            $("#alert-msg").show();
	        },
	        error: function(xhr, textStatus) {
	            alert(textStatus);
	        }
	    });
	});
	
	/*===================================*
	07. SCROLLUP JS
	*===================================*/
	$(window).on('scroll', function() {
		if ($(this).scrollTop() > 150) {
			$('.scrollup').fadeIn();
		} else {
			$('.scrollup').fadeOut();
		}
	});
	
	$(".scrollup").on('click', function (e) {
		e.preventDefault();
		$('html, body').animate({
			scrollTop: 0
		}, 600);
		return false;
	});
	
	
	/*===================================*
	08. POPUP JS
	*===================================*/
	$('.content-popup').magnificPopup({
		type: 'inline',
		preloader: true,
		mainClass: 'mfp-zoom',
	});
	
	
	$('.image_gallery').each(function() { // the containers for all your galleries
		$(this).magnificPopup({
			delegate: 'a', // the selector for gallery item
			type: 'image',
			gallery: {
				enabled:true
			},
			zoom: {
				enabled: true,
				duration: 300, // don't foget to change the duration also in CSS
				opener: function(element) {
					return element.find('img');
				}
			}
		});
	});
	
	$(document).on('ready', function() {
		$('.popup-ajax').magnificPopup({
			type: 'ajax',
		});
	});

	
	$('.portfolio_item .image_popup').on('click', function () {
		$(this).find('.link_container').magnificPopup('open');
	});
	$('.link_container').each(function () {
		$(this).magnificPopup({
			delegate: '.image_popup',
			type: 'image',
			gallery: {
				enabled: true
			}
		});
	});
	
	/*==============================================================
    09. VIDEO JS
    ==============================================================*/
	$(document).on('ready', function() {
		$('.video_popup, .iframe_popup').magnificPopup({
			type: 'iframe',
			mainClass: 'mfp-fade',
			removalDelay: 160,
			preloader: false,
			fixedContentPos: false
		});
	});
	
	/*===================================*
	10. ANIMATION JS
	*===================================*/
	$(function() {
	
		function ckScrollInit(items, trigger) {
			items.each(function() {
				var ckElement = $(this),
					AnimationClass = ckElement.attr('data-animation'),
					AnimationDelay = ckElement.attr('data-animation-delay');
	
				ckElement.css({
					'-webkit-animation-delay': AnimationDelay,
					'-moz-animation-delay': AnimationDelay,
					'animation-delay': AnimationDelay,
					opacity: 0
				});
	
				var ckTrigger = (trigger) ? trigger : ckElement;
	
				ckTrigger.waypoint(function() {
					ckElement.addClass("animated").css("opacity", "1");
					ckElement.addClass('animated').addClass(AnimationClass);
				}, {
					triggerOnce: true,
					offset: '90%',
				});
			});
		}
	
		ckScrollInit($('.animation'));
		ckScrollInit($('.staggered-animation'), $('.staggered-animation-wrap'));
	
	});
	
	/*===================================*
	11. BACKGROUND IMAGE JS
	*===================================*/
	/*data image src*/
	$(".background_bg").each(function() {
		var attr = $(this).attr('data-img-src');
		if (typeof attr !== typeof undefined && attr !== false) {
			$(this).css('background', 'url(' + attr + ') center center/cover');
		}
	});
	
	/*===================================*
	12. PROGRESS BAR JS
	*===================================*/
	$(document).on('ready', function() {
		$('.progress .progress-bar').css("width",
			function() {
				return $(this).attr("aria-valuenow") + "%";
			}
		);
	
		$('.count_pr').css("left",
			function() {
				return $(this).attr("data-percent") + "%";
			}
		);
	});
	
	/*===================================*
	13. COUNTER JS
	*===================================*/
	$('.counter').counterUp({
		time: 1500
	});
	
	/*===================================*
	14. PARALLAX JS
	*===================================*/
	$(window).on('load', function() {
        $('.parallax_bg').parallaxBackground();
	});
	
})(jQuery);