// function startTimer(time) {
//     let obj = $("<div>").data('timer', time).appendTo('.col-12');
//
//     obj.TimeCircles({
//         animation: "smooth",
//         bg_width: 0.4,
//         fg_width: 0.043333333333333335,
//         circle_bg_color: "#f0b00b",
//         time: {
//             Days: {show: false},
//             Hours: {color: "#0275d8"},
//             Minutes: {color: "#0275d8"},
//             Seconds: {color: "#0275d8"}
//         }
//     }).addListener(function (unit, value, total) {
//         if(total === 0){
//             obj.fadeOut();
//         }
//     });
// }