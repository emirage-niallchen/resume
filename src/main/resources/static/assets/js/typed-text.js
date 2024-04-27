$(document).ready(function ($) {
    'use strict';
	/*===================================*
	TYPED TEXT JS
	*===================================*/

    var typed = new Typed('#typed-text', {
        stringsElement: '#typed-strings',
        typeSpeed: 60,
        backSpeed: 30,
        startDelay: 1000,
        loop: true,
        loopCount: Infinity
    });
});