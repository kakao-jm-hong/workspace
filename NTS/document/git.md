# 정리

## 저장소 url 변경
```
git remote set-url origin <remote-url>
```

## 시각적으로 git log 보는 법
```
git log --all --oneline --decorate --graph -10
```

## 브랜치명 비교
```
// git diff <branch명> <다른 branch명> 
git diff origin/masetr origin/develop
```

## 현재 staged 된 수정사항 만 따로 확인
```
git diff --cachhed
```

## 현재 unstaged 된 수정사항 확인
```
git diff
```

## 추적 중인 파일 삭제
```
git rm rm_test
```

## mv는 디렉토리 상에서 이름 변경하는 것과 다르다.
## 디렉토리상 이름변경하면 삭제와 생성으로 분류된다.
```
git mv <변경전 이름s> <변경후 이름>
```
## 브랜치 변경
```
git checkout <브랜치명>
git switch <브랜치명>
```
## 브랜치 생성 and dlehd
```
git checkout -b <브랜치명>
git switch -c <브랜치명>
``` 

## 브랜치 삭제 (병합 후)
```
git branch -d <브랜치명>
```

## 브랜치 삭제 (병합 전)
```
git branch -D <브랜치명>
```

## stash commit 전 작업을 저장한다
```
git stash-u
```

## 목록 확인
```
git stash list
```

## stash 이름변경
```
//git stash save <stash-name>

git stash save -a <stash 저장 명칭> <파일이름s>
```

## stash 확인
```
git show stash@{1}
```

## 최근 stash 불러오기
```
// 스택구조
git stash pop
```

## stash를 반영하고 목록에서 제거하지 않음
```
git stash apply
```
## 마지막 commit 변경
```
commit --amend
```

## 부분 병합
```
git cherry-pick <커밋 id>
git cherry-pick <커밋 id>^..<커밋 id>
```

## rebase
```
git rebase feature/rebase develop
```

## rebase 끝내기
```
rebase --abort
```

## 이전 코밋 로그보기
```
git reflog
```

## 원겨 pull 충돌 시
```
git pull --rebase
```
 
# 틀린 문제 정리

## stash