class Stack {
    constructor() {
        this.store = [];
    }

    push(item) {
        this.store.push(item);
    }

    pop() {
        return this.store.pop();
    }
}
var Reverse;
var nodeCnt;
var stack;
var visited;
var depth;

function solution(next_student) {
    nodeCnt = next_student.length;
    Reverse = new Array(nodeCnt + 1);
    for (let i = 1; i < nodeCnt; i++) {
        Reverse[i] = new Array();
    }

    visited = new Array(nodeCnt + 1);
    visited.fill(false);
    visited[0] = true;
    stack = new Stack();
    depth = new Array(nodeCnt + 1);
    depth.fill(0);

    // 노드 새로만들어줍니다.
    for (let i = 0; i < nodeCnt; i++) {
        Reverse[next_student[i]].push(i + 1);
    }

    // SCC

    for (let i = 1; i <= nodeCnt; i++) {
        if (visited[i])
            continue;
        dfs(i);
    }

    // stack잇는 애를 하나식 뽑으면서 조사하면된다.
    visited.fill(false);
    visited[0] = true;

    while (stack.store.length != 0) {
        let here = stack.pop();
        if (visited[here])
            continue;
        if (depth[here] == 0)
            depth[here] = 1;
        getAnswer(here);

    }

    // console.log(ansArr);

    var answer = 0;
    var maxValue = 0;
    for (let i = 1; i < depth.length; i++) {
        if (depth[i] < maxValue) {
            answer = i;
            maxValue = depth[i];
        } else if (depth[i] == maxValue) {
            answer = i;
        }
    }


    return answer;
}


function getAnswer(h) {
    visited[h] = true;
    if (!visited[Reverse[h]]) {
        depth[Reverse[h]] = depth[h]+1;
        getAnswer(Reverse[h]);
    } else {
        depth = parseInt(d) + 1;
        return;
    }
}

// 스택쌓기
function dfs(v) {
    visited[v] = true;
    if (!visited[Reverse[v]]) {
        dfs(Reverse[v]);
    }
    stack.push(v);
}

console.log(solution([5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2]));