package test;

// T1 holds lock on critical section 1
// --> tryLock(long timeout, TimeUnit timeunit) and make sure to acquire lock without blocking indefinitely
// if there's no lock it will return false; this will avoid waiting indefinitely
// T2 holds lock on critical section 2
// T1 is trying to access critical section 2
// T2 is trying to access critical section 1
public class Test {
}
