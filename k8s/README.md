# K8S

```
kubectl get node

kubectl get namespace

kubectl get po -n monitoring
```

## Master
etcd : 모든 데이터를 확실하게 관리

api server : etcd와 유일하게 통신

Scheduler : 어떤 노드에 어떤 컨테이너를??

Controller : 끊임없이 상태를 체크한다. (단일프로세스)

### 조회흐름

1. Controller가 Api Server에게 조회
2. Api Server는 etcd를 조회한다
3. API Server는 Controller에 알려주고 
4. 원하는 상태로 변경하고
5. 리소스 변경 상태를 API Server에게 전달 (권한 체크)
6. etcd 갱신

### Poid
- 보통 하나만 존재하긴 하지만 두개가 존한다 pot안에 콘테이너가
- container/ log
- container / cache

### replicas
- 몇개의 pod을 관리할지 설정

### deployment
- replicas를 감싼 애
- version을 나눕니다.
- replicaSet을 활용해서 무중단 배포를 한다.

### 그외
- Daemon Set : 모든 node에 꼭하나신만 떠있게 하고싶을 때
- Stateful Sets : pod 순서지정
- Job : 한번실행하고 죽는 pod

### Sercie - ClusterIp
- pod은 동적이지만 서비스는 고유 Ip를 가짐 그래서 pod에 요청을 보내는게 아니라 Service에 보낸다.

### Service - NodePort
- 외부에서 접근 하고 싶을 때 노드 포트를 통해서 접속하고 그용청이 다시 ClusterIp로 가고 그게 다시 pod으로 간다.

