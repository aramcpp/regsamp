import com.synisys.go.Task.business.model.UserInfo;
import com.synisys.go.Task.business.model.impl.UserInfoImpl;
import com.synisys.go.Task.persistance.dao.impl.fs.UserInfoDao;

/**
 * Created by meruzhan.gasparyan on 10/11/2016.
 */
public class UserInfoDaoTest {
    public static void main(String[] args) {
//
        UserInfo user = new UserInfoImpl();
        user.setAge(12);
        user.setLastName("asdsad");
        user.setFirstName("asdere");

//        UserInfo user1 = new UserInfoImpl(1,"us1","us1",25);

        UserInfoDao dao = new UserInfoDao();


//         test create method UserInfoDao class
        dao.create(user);

        /*test load method UserInfoDao class
         UserInfo userInfo =  dao.load(1);
         System.out.println(userInfo.getFirstName());
         System.out.println(userInfo.getLastName());
    `   */

        /*test delete method UserInfoDao class
         dao.delete(3);
        */

        /*test update method UserInfoDAO class
        dao.update(user1);
        */

//        UserDao userDao = new UserDao();
//        UserImpl userImpl = new UserImpl(-1,"mer","00",user);
        /*test method UserDao class
        userDao.create(userImpl);
        */

        /* test load method UserDao class
        User usertest =  userDao.load(2);
        System.out.println(usertest.getUserName());
        System.out.println(usertest.getPassword());
        System.out.println(usertest.getUserInfo().getFirstName());
        */


        /* test load method UserDao class
        userDao.delete(3);
        */

        /* test method UserDao class
        UserInfo userUpdate = new UserInfoImpl(2,"asdas","us1",25);
        UserImpl userImpl1 = new UserImpl(2,"m","11",userUpdate);
        userDao.update(userImpl1);
        */
    }
}
