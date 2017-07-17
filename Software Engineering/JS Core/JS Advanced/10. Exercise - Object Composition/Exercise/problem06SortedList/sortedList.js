function returnList() {
    return {
        list: [],
        size: 0,
        sort: function () {
            this.list = this.list.sort((a,b) => a-b);
        },
        add: function (element) {
            this.list.push(element);
            this.size++;
            this.sort();
        },
        remove: function (index) {
            if(index < this.list.length && index >= 0){
                this.list.splice(index, 1);
                this.size--;
            }
        },
        get: function (index) {
            if(index < this.list.length && index >= 0){
                return this.list[index];
            }
        }
    }
}