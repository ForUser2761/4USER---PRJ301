package dal;

/*				
 * Copyright (C) FPT University , Ltd. 2023	
 * 30/09/2023 FPT 4USER
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 4USER
 * @param <T>
 */
public abstract class GenericDAO<T> extends DBContext {

    protected PreparedStatement statement;
    protected ResultSet resultSet;
    protected Map<String, Object> parameterMap;
    // Các constant đại diện cho giá trị true và false trong việc sử dụng OR và AND
    public static final boolean CONDITION_AND = true;
    public static final boolean CONDITION_OR = false;
    private final Class<T> clazz;

    public GenericDAO() {
        // Lấy thông tin kiểu generic từ superclass
        Type genericSuperclass = getClass().getGenericSuperclass();

        // Kiểm tra xem genericSuperclass có phải là ParameterizedType
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] arguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (arguments != null && arguments.length > 0) {
                // Kiểm tra an toàn trước khi ép kiểu
                Type argument = arguments[0];
                if (argument instanceof Class<?>) {
                    this.clazz = (Class<T>) argument;
                } else {
                    throw new IllegalArgumentException("Không thể xác định loại T");
                }
            } else {
                throw new IllegalArgumentException("Không có đối số kiểu cho GenericDAO");
            }
        } else {
            throw new IllegalArgumentException("Lớp này không phải là một ParameterizedType");
        }
    }

    /**
     * Hàm này sử dụng để get dữ liệu từ database lên dựa trên tên bảng mà bạn
     * mong muốn.Hàm sẽ mặc định trả về một List có thể có giá trị hoặc List
     * rỗng
     *
     * @param clazz: tên bảng bạn muốn get dữ liệu về
     * @return list
     */
    protected List<T> queryGenericDAO() {
        connection = new DBContext().connection;
        List<T> result = new ArrayList<>();
        try {
            // Lấy kết nối

            // Tạo câu lệnh SELECT
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT * FROM ").append(clazz.getSimpleName());

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sqlBuilder.toString());
            // Thực thi truy vấn
            resultSet = statement.executeQuery();

            // Khai báo danh sách kết quả
            // Duyệt result set
            while (resultSet.next()) {
                // Gọi hàm mapRow để map đối tượng
                T obj = mapRow(resultSet);

                // Thêm vào danh sách kết quả
                result.add(obj);
            }

            return result;
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InstantiationException
                | NoSuchMethodException
                | InvocationTargetException
                | SQLException e) {
            System.err.println("4USER: Bắn Exception ở hàm query: " + e.getMessage());
        } finally {
            try {
                // Đóng kết nối và các tài nguyên
                if (resultSet != null) {

                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.err.println("4USER: Bắn Exception ở hàm query: " + e.getMessage());
            }
        }
        return result;
    }

    /**
     * Hàm này sử dụng để get dữ liệu từ database lên dựa trên tên bảng mà bạn
     * mong muốn Condition (optional) là ám chỉ những giá trị như and hoặc
     * or.Hãy sử dụng những biến sẵn có CONDITION_OR, CONDITION_AND ví dụ:
     * GenericDAO_HOLA.CONDITION_OR hoặc GenericDAO_HOLA.CONDITION_AND.Hàm sẽ
     * mặc định trả về một List có thể có giá trị hoặc List rỗng
     *
     * @param clazz:        tên bảng bạn muốn get dữ liệu về
     * @param sql:          câu lệnh SQL
     * @param parameterMap: hashmap chứa các parameter
     * @return list
     */
    protected List<T> queryGenericDAO(String sql) {
        connection = new DBContext().connection;
        List<T> result = new ArrayList<>();
        try {
            // Lấy kết nối

            // List parameter
            List<Object> parameters = new ArrayList<>();

            // Thêm điều kiện
            if (parameterMap != null && !parameterMap.isEmpty()) {
                // code thêm điều kiện
                for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                    Object conditionValue = entry.getValue();

                    parameters.add(conditionValue);
                }
                // Xóa phần AND hoặc OR cuối cùng khỏi câu truy vấn
            }

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sql);

            // Gán giá trị cho các tham số của câu truy vấn
            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }

            // Thực thi truy vấn
            resultSet = statement.executeQuery();

            // Khai báo danh sách kết quả
            // Duyệt result set
            while (resultSet.next()) {
                // Gọi hàm mapRow để map đối tượng
                T obj = mapRow(resultSet);

                // Thêm vào danh sách kết quả
                result.add(obj);
            }

            return result;
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InstantiationException
                | NoSuchMethodException
                | InvocationTargetException
                | SQLException e) {
            System.err.println("4USER: Bắn Exception ở hàm query: " + e.getMessage());
        } finally {
            try {
                // Đóng kết nối và các tài nguyên
                if (resultSet != null) {

                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm query: " + e.getMessage());
            }
        }
        return result;
    }

    private <T> T mapRow(ResultSet rs) throws SQLException,
            NoSuchMethodException,
            InstantiationException,
            IllegalArgumentException,
            IllegalAccessException,
            InvocationTargetException {

        // Khởi tạo đối tượng
        T obj = (T) clazz.getDeclaredConstructor().newInstance();

        // Lấy danh sách các field của lớp
        Field[] fields = clazz.getDeclaredFields();

        // Duyệt qua từng field
        for (Field field : fields) {

            // Set giá trị cho field
            Object value = getFieldValue(rs, field);
            field.setAccessible(true);
            field.set(obj, value);
        }

        return obj;
    }

    /**
     * Hàm lấy giá trị cho field từ result set
     *
     * @param rs
     * @param field
     * @return
     * @throws SQLException
     */
    private static Object getFieldValue(ResultSet rs, Field field) throws SQLException {

        Class<?> fieldType = field.getType();
        String fieldName = field.getName();

        // Kiểm tra kiểu dữ liệu và convert sang đúng kiểu
        if (fieldType == String.class) {
            return rs.getString(fieldName);
        } else if (fieldType == int.class || fieldType == Integer.class) {
            return rs.getInt(fieldName);
        } else if (fieldType == long.class || fieldType == Long.class) {
            return rs.getLong(fieldName);
        } else if (fieldType == double.class || fieldType == Double.class) {
            return rs.getDouble(fieldName);
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return rs.getBoolean(fieldName);
        } else if (fieldType == float.class || fieldType == Float.class) {
            return rs.getFloat(fieldName);
        } else if (fieldType == Date.class || fieldType == Date.class) {
            return rs.getDate(fieldName);
        } else if (fieldType == Character.class || fieldType == char.class) {
            return rs.getString(fieldName);
        } else if (fieldType == Character.class || fieldType == char.class) {
            String s = rs.getString(fieldName);
            return s.charAt(0);
        } else {
            return rs.getObject(fieldName);
        }
    }

    /**
     * Hàm này sử dụng để update thông tin của một đối tượng trong Database.Hãy
     * nhớ rằng hàm này không update ID vì mặc định các bảng sẽ để ID tự động
     * tăng
     *
     * @param sql
     * @param parameterMap: hashmap chứa các parameter
     * @return true: update thành công | false: update thất bại
     */
    protected boolean updateGenericDAO(String sql) {
        List<Object> parameters = new ArrayList<>();

        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            Object conditionValue = entry.getValue();

            parameters.add(conditionValue);
        }

        try {
            connection = new DBContext().connection;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);

            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.err.println("4USER: Bắn Exception ở hàm update: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm update: " + e.getMessage());
            }
        }
    }

    /**
     * Hàm này sử dụng để update thông tin của một đối tượng trong Database.Hãy
     * nhớ rằng hàm này không update ID vì mặc định các bảng sẽ để ID tự động
     * tăng
     *
     * @param sql
     * @param parameterMap: hashmap chứa các parameter
     * @return true: delete thành công | false: delete thất bại
     */
    protected boolean deleteGenericDAO(String sql) {
        List<Object> parameters = new ArrayList<>();

        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            Object conditionValue = entry.getValue();
            parameters.add(conditionValue);
        }

        try {
            connection = new DBContext().connection;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);

            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }
            statement.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.err.println("4USER: Bắn Exception ở hàm delete: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm update: " + e.getMessage());
            }
        }
    }

    /**
     * Tìm số lượng record của 1 bảng nào đó
     *
     * @param clazz: bảng muốn tìm
     * @return số lượng record
     */
    protected int findTotalRecordGenericDAO() {
        int total = 0;
        try {
            // Lấy kết nối
            connection = new DBContext().connection;
            // Tạo câu lệnh SELECT
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT COUNT(*) FROM ").append(clazz.getSimpleName());
            // List parameter
            List<Object> parameters = new ArrayList<>();

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sqlBuilder.toString());

            // Gán giá trị cho các tham số của câu truy vấn
            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }

            // Thực thi truy vấn
            resultSet = statement.executeQuery();

            // Khai báo danh sách kết quả
            // Duyệt result set
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }

        } catch (IllegalArgumentException | SQLException e) {
            System.err.println("4USER: Bắn Exception ở hàm findTotalRecord: " + e.getMessage());
        } finally {
            try {
                // Đóng kết nối và các tài nguyên
                if (resultSet != null) {

                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm findTotalRecord: " + e.getMessage());
            }
        }
        return total;
    }

    /**
     * Tìm số lượng record của 1 bảng nào đó, điều kiện (optional)
     *
     * @param clazz:        bảng muốn tìm
     * @param parameterMap: hashmap chứa các parameter
     * @return số lượng record
     */
    protected int findTotalRecordGenericDAO(String sql) {
        int total = 0;
        try {
            // Lấy kết nối
            connection = new DBContext().connection;
            // Tạo câu lệnh SELECT
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT COUNT(*) FROM ").append(clazz.getSimpleName());
            // List parameter
            List<Object> parameters = new ArrayList<>();

            // Thêm điều kiện
            if (parameterMap != null && !parameterMap.isEmpty()) {
                // code thêm điều kiện
                for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                    Object conditionValue = entry.getValue();

                    parameters.add(conditionValue);
                }
            }

            // Chuẩn bị câu lệnh
            statement = connection.prepareStatement(sql);

            // Gán giá trị cho các tham số của câu truy vấn
            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }

            // Thực thi truy vấn
            resultSet = statement.executeQuery();

            // Khai báo danh sách kết quả
            // Duyệt result set
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }

        } catch (IllegalArgumentException | SQLException e) {
            System.err.println("4USER: Bắn Exception ở hàm findTotalRecord: " + e.getMessage());
        } finally {
            try {
                // Đóng kết nối và các tài nguyên
                if (resultSet != null) {

                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm findTotalRecord: " + e.getMessage());
            }
        }
        return total;
    }

    protected void insertGenericDAO(String sql) {

        List<Object> parameters = new ArrayList<>();

        for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            Object conditionValue = entry.getValue();

            parameters.add(conditionValue);
        }

        try {
            connection = new DBContext().connection;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);

            int index = 1;
            for (Object value : parameters) {
                statement.setObject(index, value);
                index++;
            }
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.err.println("4USER: Bắn Exception ở hàm update: " + ex.getMessage());
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("4USER: Bắn Exception ở hàm insert: " + e.getMessage());
            }
        }
    }

    public abstract List<T> findAll();

    public abstract int insert(T t);

}
