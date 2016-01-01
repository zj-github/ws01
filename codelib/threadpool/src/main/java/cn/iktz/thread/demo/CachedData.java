package cn.iktz.thread.demo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class LoginUser{
	public int id;
	public String loginName;
	public String password;
	public static LoginUser getLoginUser(int id){
		LoginUser loginUser = new LoginUser();
		//dao.selectLoginUserByID(id)
		return loginUser ;
	}
}
class CachedData {
	LoginUser loginUser;
	volatile boolean cacheValid;
	ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		rwl.readLock().lock();
		if (!cacheValid) {//��һ�ζ����ݵ�ʱ��LoginUser�ǿյ�
			// Must release read lock before acquiring write lock
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			// Recheck state because another thread might have acquired
			// write lock and changed state before we did.
			if (!cacheValid) {//���û�л��棬
				loginUser = LoginUser.getLoginUser(01);
				cacheValid = true;
			}
			// Downgrade by acquiring read lock before releasing write lock
			rwl.readLock().lock();
			rwl.writeLock().unlock(); // Unlock write, still hold read
		}

		//Ӧ������
		System.out.println(loginUser);
		rwl.readLock().unlock();
	}
}
