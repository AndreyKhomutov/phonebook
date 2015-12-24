package com.getjavajob.training.web06.khomutova.service.converters;

import com.getjavajob.training.web06.khomutova.datebaseclasses.dto.PhoneDTO;
import com.getjavajob.training.web06.khomutova.phonebookclasses.Phone;

public class PhoneConverter {

    public Phone fromDTOToPhone(PhoneDTO phoneDTO) {
        Phone phone = new Phone();
        return phone;
    }

    public PhoneDTO fromPhoneToDTO(Phone phone) {
        PhoneDTO phoneDTO = new PhoneDTO();
        return phoneDTO;
    }
}
