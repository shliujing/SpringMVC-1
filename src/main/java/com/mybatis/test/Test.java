package com.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("test/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public void getUserByID(int userID) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(userID);
			if (user != null) {
				System.out.println(user.getId() + ":" + user.getUserName()
						+ ":" + user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}

	public void getUserList(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			List<User> users = userOperation.selectUsersByName(userName);
			for (User user : users) {
				System.out.println(user.getId() + ":" + user.getUserName()
						+ ":" + user.getUserAddress());
			}

		} finally {
			session.close();
		}
	}

	/**
	 * 增加后要commit
	 */
	public void addUser() {
		User user = new User();
		user.setUserAddress("place");
		user.setUserName("test_add");
		user.setUserAge(30);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();
			System.out.println("新增用户ID：" + user.getId());
		} finally {
			session.close();
		}
	}

	/**
	 * 修改后要commit
	 */
	public void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			User user = userOperation.selectUserByID(1);
			if (user != null) {
				user.setUserAddress("A new place");
				userOperation.updateUser(user);
				session.commit();
			}
		} finally {
			session.close();
		}
	}

	/**
	 * 删除后要commit.
	 *
	 * @param id
	 */
	public void deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session
					.getMapper(IUserOperation.class);
			userOperation.deleteUser(id);
			session.commit();
		} finally {
			session.close();
		}
	}

	/**
	 * 最后获取的还是单个Article
	 *
	 * @param userid
	 */
	public void getUserArticles(int userid) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			List<Article> articles = userOperation.getUserArticles(userid);
			for (Article article : articles) {
				System.out.println(article.getTitle() + ":" + article.getContent() +
						":作者是:" + article.getUser().getUserName() + ":地址:" +
						article.getUser().getUserAddress());
			}
		} finally {
			session.close();
		}
	}


	public static void main(String[] args) {
		try {
			Test test = new Test();
			 test.getUserByID(1);
			 test.getUserList("test1");
			 test.addUser();
			 test.updateUser();
			 test.deleteUser(6);
			test.getUserArticles(1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}