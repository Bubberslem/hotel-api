package app.daos;

import app.dtos.HotelDTO;
import app.dtos.RoomDTO;
import java.util.List;

public interface IDAO {

    // Hotel CRUD
    List<HotelDTO> getAllHotels();
    HotelDTO getHotelById(int id);
    HotelDTO create(HotelDTO dto);
    HotelDTO updateHotel(int id, HotelDTO dto);
    void deleteHotel(int id);

    // Room management
    HotelDTO addRoom(int hotelId, RoomDTO roomDto);
    HotelDTO removeRoom(int hotelId, int roomId);
    List<RoomDTO> getRoomsForHotel(int hotelId);
}