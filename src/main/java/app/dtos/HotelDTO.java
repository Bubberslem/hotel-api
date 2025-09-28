package app.dtos;

import app.entities.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDTO {
    private int id;
    private String name;
    private String address;
    private Integer rooms;
    private Integer stars;
    private Set<RoomDTO> roomSet;

    public HotelDTO(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.rooms = hotel.getRooms();
        this.stars = hotel.getStars();
    }
    public static List<HotelDTO> toDTOList(List<Hotel> hotels){
        return hotels.stream().map(HotelDTO::new).toList();
    }
}
