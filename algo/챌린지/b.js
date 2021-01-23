var map;
var size;
var len;
function solution(m, v) {
    len = v.length;
    map = new Array(len);
    map.fill(0);
    size = m;
    var answer =0;
    for (let i = 0; i < v.length; i++) {
        let block = v[i];
        // 왼쪽을 기준으로 어디에 넣을 수 있는지 탐색

        let where = whereGo(block);
        map[where] += block;
    }
    var answer = getAnswer();
    return answer;
}
function whereGo(block) {
    for (let i = len-1; i >=0; i--) {
        if (map[i] + parseInt(block) > size) {
            return i+1;
        }
    }
    return 0;
}


//  왼쪽 정렬 왼쪽만 비교해주면 됩니다.
function getAnswer() {
    for (let i = len - 1; i >= 0; i--) {
        if (map[i] != 0)
            return i + 1;
    }
    return 0;
}

var ans = solution(4, [2, 3, 1]);
console.log(ans);