package app.dtos;

import app.entities.Room;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomDTO {
    private int id;
    private int number;
    private double price;
    private int hotelId; // så vi ved hvilket hotel rummet hører til

    // Entity -> DTO
    public RoomDTO(Room room) {
        this.id = room.getId();
        this.number = room.getNumber();
        this.price = room.getPrice();
        this.hotelId = room.getHotel() != null ? room.getHotel().getId() : 0;
    }

    // DTO -> Entity (valgfri)
    public Room toEntity() {
        Room room = new Room();
        room.setId(this.id);
        room.setNumber(this.number);
        room.setPrice(this.price);
        return room;
    }
}
