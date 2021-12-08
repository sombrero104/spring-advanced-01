<br/>

# 스프링 핵심 원리 - 고급편 
<br/>

# ThreadLocal
<br/>

### 동시성 문제 
<img src="./images/sync/sync_problem.png" /><br/>
<br/><br/>

### ThreadLocal이란
<img src="./images/sync/threadLocal.png" width="70%" /><br/>
<br/><br/>

### ThreadLocal 실험 
#### ThreadLocal 사용 전
<img src="./images/sync/before_threadLocal.png" /><br/>
<img src="./images/sync/before_threadLocal2.png" /><br/>
#### ThreadLocal 사용 후 
<img src="./images/sync/after_threadLocal.png" /><br/>
<br/><br/>

### ThreadLocal 사용 시 반드시 주의해야 할 점 
<img src="./images/sync/threadLocal_need_remove_01.png" width="70%" /><br/>
<img src="./images/sync/threadLocal_need_remove_02.png" width="70%" /><br/>
<img src="./images/sync/threadLocal_need_remove_03.png" width="70%" /><br/>
<img src="./images/sync/threadLocal_need_remove_04.png" width="70%" /><br/>
<br/><br/>

##### * ThreadLocal에 세션 저장해서 사용하기 
https://velog.io/@skygl/ThreadLocal

<br/><br/><br/><br/>

## '변하는 것과 변하지 않는 것을 분리'

### 템플릿 패턴
<br/><br/>

### 전략 패턴
<br/><br/>

### 템플릿 콜백 패턴 
#### * 콜백 정의
프로그래밍에서 콜백(callback) 또는 콜애프터 함수(call-after function)는 <br/>
다른 코드의 인수로서 넘겨주는 실행 가능한 코드를 말한다. <br/>
콜백을 넘겨받는 코드는 이 콜백을 필요에 따라 즉시 실행할 수도 있고, 아니면 나중에 실행할 수도 있다. <br/>
쉽게 이야기해서 callback은 코드가 호출(call)은 되는데 코드를 넘겨준 곳의 뒤(back)에서 실행된다는 뜻이다. <br/>
<br/><br/>


<br/><br/><br/><br/>