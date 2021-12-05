<br/>

# 스프링 핵심 원리 - 고급편 
<br/>

# ThreadLocal
<br/>

### 동시성 문제 
<img src="./images/sync/sync_problem.png" /><br/>
<br/><br/>

### ThreadLocal이란
<img src="./images/sync/threadLocal.png" width="75%" /><br/>
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

<br/><br/>

