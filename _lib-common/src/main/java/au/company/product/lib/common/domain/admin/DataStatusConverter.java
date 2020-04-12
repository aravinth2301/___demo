package au.company.product.lib.common.domain.admin;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import au.company.product.lib.common.util.BadRequestException;
import au.company.product.lib.common.util.Error;

@Converter(autoApply = true)
public class DataStatusConverter implements AttributeConverter<DataStatus,Integer> {

	@Override
	public Integer convertToDatabaseColumn(DataStatus attribute) {
		if(attribute !=null) {
			return attribute.getId();
		}
		return null;
	}

	@Override
	public DataStatus convertToEntityAttribute(Integer dbData) {
		if(DataStatus.Enum.ACTIVE.getId().equals(dbData)) {
			return new DataStatus(DataStatus.Enum.ACTIVE);
		}else if(DataStatus.Enum.DEACTIVE.getId().equals(dbData)) {
			return new DataStatus(DataStatus.Enum.DEACTIVE);
		}
		throw new BadRequestException(Error.INVALID_DATA_VALUE, dbData+"");
	}

}
