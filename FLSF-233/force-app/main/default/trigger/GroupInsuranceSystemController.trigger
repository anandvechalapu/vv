Trigger:

trigger CreateGroupInsurance on Group_Insurance__c (before insert, before update) {

// Lead generation and creation
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Lead_Generation__c != null){
        LeadGenerationHandler.createLead(Trigger.new[0]);
    }
}

// Proposal and Quotation generation
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Proposal_Generation__c != null){
        ProposalGenerationHandler.createProposal(Trigger.new[0]);
    }
}

// Configure master policy
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Master_Policy_Configuration__c != null){
        MasterPolicyHandler.configureMasterPolicy(Trigger.new[0]);
    }
}

// Underwrite policy
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Underwriting__c != null){
        PolicyUnderwritingHandler.underwritePolicy(Trigger.new[0]);
    }
}

// Approve deviations
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Deviation_Approvals__c != null){
        DeviationApprovalsHandler.approveDeviations(Trigger.new[0]);
    }
}

// Actuarial valuation
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Actuarial_Valuation__c != null){
        ActuarialValuationHandler.valueGroupInsurance(Trigger.new[0]);
    }
}

// Reinsurance pricing
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Reinsurance_Pricing__c != null){
        ReinsurancePricingHandler.priceReinsurance(Trigger.new[0]);
    }
}

// Underwriting pricing
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Underwriting_Pricing__c != null){
        UnderwritingPricingHandler.priceUnderwriting(Trigger.new[0]);
    }
}

// Manage member data
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Manage_Member_Data__c != null){
        MemberDataHandler.manageMemberData(Trigger.new[0]);
    }
}

// Update leads
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Leads_Update__c != null){
        LeadsUpdateHandler.updateLeads(Trigger.new[0]);
    }
}

// Commission receipts
if(Trigger.isInsert || Trigger.isUpdate){ 
    if(Trigger.new[0].Commission_Receipts__c != null){
        CommissionReceiptHandler.acknowledgeReceipts(Trigger.new[0]);
    }
}

}