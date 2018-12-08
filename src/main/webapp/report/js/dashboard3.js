$(document).ready(function () {
    "use strict";
    $(".counter").counterUp({
        delay: 100,
        time: 1200
    });

    $('.vcarousel').carousel({
        interval: 3000
    })
    $('#usa').vectorMap({
        map: 'us_aea_en',
        markers: [
            {
                latLng: [36.77, -119.41],
                name: 'California visit : 250'

      },
            {
                latLng: [34.15, -105],
                name: 'New Maxico visit : 250'

      },
            {
                latLng: [41.49, -99.90],
                name: 'Nebraska visit   : 1250'

      },
            {
                latLng: [25.20, 55.27],
                name: 'UAE : 250'

      }],

        backgroundColor: 'transparent',
        regionStyle: {
            initial: {
                fill: '#c1ccd1'
            }
        }
    });

    //ct-weather
    new Chartist.Line('#ct-city-wth', {
        labels: ['12AM', '2AM', '6AM', '9AM', '12AM', '3PM', '6PM', '9PM'],
        series: [
    [5, 2, 7, 4, 5, 3, 5, 4]
  ]
    }, {
        chartPadding: {
            left: -20,
            top: 10,
        },
        low: 1,
        showPoint: true,
        fullWidth: true,
        plugins: [
    Chartist.plugins.tooltip()
  ],
        axisX: {
            showLabel: true,
            showGrid: false
        },
        axisY: {
            showLabel: false,
            showGrid: false
        },
        showArea: true
    });

    $("#sparkline8").sparkline([2, 4, 4, 6, 8, 5, 6, 4, 8, 6, 6, 2], {
        type: 'line',
        width: '100%',
        height: '50',
        lineColor: '#cfecfe',
        fillColor: '#cfecfe',
        maxSpotColor: '#cfecfe',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#cfecfe'
    });
    $("#sparkline9").sparkline([0, 2, 8, 6, 8, 5, 6, 4, 8, 6, 6, 2], {
        type: 'line',
        width: '100%',
        height: '50',
        lineColor: '#f1effd',
        fillColor: '#f1effd',
        minSpotColor: '#f1effd',
        maxSpotColor: '#f1effd',
        highlightLineColor: 'rgba(0, 0, 0, 0.2)',
        highlightSpotColor: '#f1effd'
    });
    var sparkResize;

    $(window).on("resize", function (e) {
        clearTimeout(sparkResize);
        sparkResize = setTimeout(sparklineLogin, 500);
    });
});
