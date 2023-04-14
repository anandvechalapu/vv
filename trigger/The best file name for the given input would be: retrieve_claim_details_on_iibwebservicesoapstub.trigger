trigger RetrieveClaimDetails on IIBWebServiceSOAPStub (before insert, before update) { 
  //Check if the required fields have been populated 
  if(Trigger.isBefore && (Trigger.isInsert || Trigger.isUpdate)) { 
    if(Trigger.new[0].Username == null || Trigger.new[0].Password == null || Trigger.new[0].PolicyNumber == null 
       || Trigger.new[0].InsurerName == null || Trigger.new[0].RegistrationNumber == null || Trigger.new[0].ChassisNumber == null 
       || Trigger.new[0].EngineNumber == null){
      // Raise an exception if any of the required fields are missing 
      throw new Exception('The required fields are not populated');
    }
  } 
  //Call the SOAP client to retrieve claim details
  IIBWebServiceSOAPStub.getClaimDetails(Trigger.new[0].Username, Trigger.new[0].Password, Trigger.new[0].PolicyNumber, 
                                       Trigger.new[0].InsurerName, Trigger.new[0].RegistrationNumber, Trigger.new[0].ChassisNumber, 
                                       Trigger.new[0].EngineNumber);
  
  //Handle errors returned by the external API
  if(IIBWebServiceSOAPStub.getError() != null){
    throw new Exception('Error retrieving claim details: ' + IIBWebServiceSOAPStub.getError());
  }
}