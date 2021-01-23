var size = 5;
var server;
function solution(n, record) {
    var answer = [];
    server = new Array(n + 1);
    var serverpivot = Array(n + 1);
    serverpivot.fill(0);
    for (let i = 1; i <= n; i++) {
        server[i] = new Array(size);
    }


    for (let i = 0; i < record.length; i++) {
        let words = record[i].split(' ');
        let num = parseInt(words[0]);
        let id = words[1];
        // console.log(num +" "+id);
        if (!isExit(num, id)) {
            server[num][serverpivot[num]] = id;
            serverpivot[num] = (serverpivot[num] + 1) % size;
        }
    }

    for (let i = 1; i <= n; i++) {
        //pivot ~ 4까지
        //0 ~ pivot까지 추가
        for (let j = serverpivot[i]; j < 5; j++) {
            if (server[i][j] === undefined)
                continue;
            answer.push(server[i][j]);
        }
        for (let j = 0; j < serverpivot[i]; j++) {
            if (server[i][j] === undefined)
                continue;
            answer.push(server[i][j]);
        }
    }

    console.log(answer);
    return answer;
}

function isExit(num, id) {
    for (let i = 0; i < size; i++) {
        if (server[num][i] == id) {
            return true;
        }
    }
    return false;
}

solution(4, ["1 a", "1 b", "1 abc", "3 b", "3 a", "1 abcd", "1 abc", "1 aaa", "1 a", "1 z", "1 q", "3 k", "3 q", "3 z", "3 m", "3 b"]);