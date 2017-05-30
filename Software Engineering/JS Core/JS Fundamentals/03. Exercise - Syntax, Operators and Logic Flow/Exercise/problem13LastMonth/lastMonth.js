function lastMonth(params) {
    let [day, month, year] = params;
    let date = new Date(year, month - 1, day);
    date.setDate(0);
    console.log(date.getDate());
}