package iuh.fit.bai11_jakarta_ee_rest_api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class UserResource {


    @GET
    @Path("/view")
    @Produces("text/json")
    public String viewUser() {
        return "Gia Minh";
    }


    @GET
    @Path("/add/{a}/{b}")
    public int add(@PathParam("a") int a, @PathParam("b") int b) {
        return a + b;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Gia Minh", "minh@gmail.com"));
        userList.add(new User(2, "Cong Chung", "chung@gmail.com"));
        return Response.ok(userList).build();
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        if (id == 1) {
            return Response.ok(new User(1, "Gia Minh", "minh@gmail.com")).build();
        } else if (id == 2) {
            return Response.ok(new User(2, "Cong Chung", "chung@gmail.com")).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Không tìm thấy người dùng với ID: " + id)
                    .build();
        }
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        System.out.println("Tạo user mới: " + user.getName());
        return Response.status(Response.Status.CREATED)
                .entity("Đã thêm người dùng thành công!")
                .build();
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, User updatedUser) {
        System.out.println("Cập nhật user ID " + id + " thành " + updatedUser.getName());
        return Response.ok("Đã cập nhật xong!").build();
    }

    // 5. DELETE - Xóa User theo id
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        System.out.println("Đã xóa user ID: " + id);
        return Response.ok("Xóa người dùng thành công!").build();
    }
}
