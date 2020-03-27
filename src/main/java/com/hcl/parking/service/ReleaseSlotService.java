package com.hcl.parking.service;
/***
 * 
 * @author Anuradha
 *
 */

import com.hcl.parking.dto.ReleaseSlotDto;
import com.hcl.parking.dto.ResponseDto;

public interface ReleaseSlotService {
	
	ResponseDto releaseSlot(ReleaseSlotDto releaseSlotDto);

}
