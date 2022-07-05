import request from '@/utils/request'

// 初期
export function personalInformationInit() {
    return request({
        url: '/C010101/init',
        method: 'post',
    })
}

// 01 新規
export function personalInformationInsert(
    companyId,
    userCd,
    applicantId,
    photo,
    countryId,
    birthday,
    applicantPostal,
    address1,
    address2,
    station,
    industryId1,
    jobtypeId1_1,
    jobtypeId1_2,
    jobtypeId1_3,
    industryId2,
    jobtypeId2_1,
    jobtypeId2_2,
    jobtypeId2_3,
    industryId3,
    jobtypeId3_1,
    jobtypeId3_2,
    jobtypeId3_3,
    hopeLand1,
    hopeLand2,
    hopeLand3,
    graduationSchool,
    graduationMajor,
    finalEducation,
    workYears,
    hopeSalaryFrom,
    hopeSalaryTo,
    workSituation,
    specialty,
    reason,
    introduce,
    interest,
    remarks, ) {
    return request({
        url: '/C010101/insert',
        method: 'post',
        data: {
            companyId,
            userCd,
            applicantId,
            photo,
            countryId,
            birthday,
            applicantPostal,
            address1,
            address2,
            station,
            industryId1,
            jobtypeId1_1,
            jobtypeId1_2,
            jobtypeId1_3,
            industryId2,
            jobtypeId2_1,
            jobtypeId2_2,
            jobtypeId2_3,
            industryId3,
            jobtypeId3_1,
            jobtypeId3_2,
            jobtypeId3_3,
            hopeLand1,
            hopeLand2,
            hopeLand3,
            graduationSchool,
            graduationMajor,
            finalEducation,
            workYears,
            hopeSalaryFrom,
            hopeSalaryTo,
            workSituation,
            specialty,
            reason,
            introduce,
            interest,
            remarks,
        }
    })
}

// 01 削除
export function personalInformationUpdate(
    companyId,
    userCd,
    applicantId,
    photo,
    countryId,
    birthday,
    applicantPostal,
    address1,
    address2,
    station,
    industryId1,
    jobtypeId1_1,
    jobtypeId1_2,
    jobtypeId1_3,
    industryId2,
    jobtypeId2_1,
    jobtypeId2_2,
    jobtypeId2_3,
    industryId3,
    jobtypeId3_1,
    jobtypeId3_2,
    jobtypeId3_3,
    hopeLand1,
    hopeLand2,
    hopeLand3,
    graduationSchool,
    graduationMajor,
    finalEducation,
    workYears,
    hopeSalaryFrom,
    hopeSalaryTo,
    workSituation,
    specialty,
    reason,
    introduce,
    interest,
    remarks, ) {
    return request({
        url: '/C010101/update',
        method: 'post',
        data: {
            companyId,
            userCd,
            applicantId,
            photo,
            countryId,
            birthday,
            applicantPostal,
            address1,
            address2,
            station,
            industryId1,
            jobtypeId1_1,
            jobtypeId1_2,
            jobtypeId1_3,
            industryId2,
            jobtypeId2_1,
            jobtypeId2_2,
            jobtypeId2_3,
            industryId3,
            jobtypeId3_1,
            jobtypeId3_2,
            jobtypeId3_3,
            hopeLand1,
            hopeLand2,
            hopeLand3,
            graduationSchool,
            graduationMajor,
            finalEducation,
            workYears,
            hopeSalaryFrom,
            hopeSalaryTo,
            workSituation,
            specialty,
            reason,
            introduce,
            interest,
            remarks,
        }
    })
}

// 02 新規
export function qualificationCertificateInsertQua(
    acquisitionDate,
    appQuaId,
    applicantId,
    createBy,
    createTime,
    delFlg,
    quaAddress,
    quaNm,
    quaNum,
    remarks,
    updateBy,
    updateTime,
) {
    console.log("insertQua is running.");
    return request({
        url: '/C010102/insertQua',
        method: 'post',
        data: {
            acquisitionDate,
            appQuaId,
            applicantId,
            createBy,
            createTime,
            delFlg,
            quaAddress,
            quaNm,
            quaNum,
            remarks,
            updateBy,
            updateTime,
        }
    })
}

// 02 削除
export function qualificationCertificateDeleteQua(
    applicantId,
    appQuaId,
) {
    console.log("deleteQua is running.", applicantId, appQuaId);
    return request({
        url: '/C010102/deleteQua',
        method: 'post',
        data: {
            applicantId,
            appQuaId,
        }
    })
}

// 02 編集
export function qualificationCertificateUpdateQua(
    acquisitionDate,
    appQuaId,
    applicantId,
    quaAddress,
    quaNm,
    quaNum,
    remarks,
) {
    console.log("updateQua is running.");
    return request({
        url: '/C010102/updateQua',
        method: 'post',
        data: {
            acquisitionDate,
            appQuaId,
            applicantId,
            quaAddress,
            quaNm,
            quaNum,
            remarks,
        }
    })
}

// 03 新規
export function skillInformationInsertSkill(
    companyId,
    userCd,
    appSkillId,
    applicantId,
    skillId,
    expSection,
    otherNm,
) {
    console.log("insertSkill is running.");
    return request({
        url: '/C010103/insertSkill',
        method: 'post',
        data: {
            companyId,
            userCd,
            appSkillId,
            applicantId,
            skillId,
            expSection,
            otherNm,
        }
    })
}

// 03 削除
export function skillInformationDeleteSkill(
    applicantId,
    appSkillId,
) {
    console.log("deleteSkill is running.", applicantId, appSkillId);
    return request({
        url: '/C010103/deleteSkill',
        method: 'post',
        data: {
            applicantId,
            appSkillId,
        }
    })
}

// 03 編集
export function skillInformationUpdateSkill(
    companyId,
    userCd,
    appSkillId,
    applicantId,
    skillId,
    expSection,
    otherNm,
) {
    console.log("updateSkill is running.");
    return request({
        url: '/C010103/updateSkill',
        method: 'post',
        data: {
            companyId,
            userCd,
            appSkillId,
            applicantId,
            skillId,
            expSection,
            otherNm,
        }
    })
}

// 04 新規
export function workExperienceInsertWorkHis(
    companyId,
    userCd,
    workHisId,
    applicantId,
    companyNm,
    industryId1,
    jobtypeId1_1,
    jobtypeId1_2,
    jobtypeId1_3,
    workPosition,
    workPlace,
    workSkill,
    workDateFrom,
    workDateTo,
    introduction,
    workContent,
) {
    console.log("insertWorkHis is running.");
    return request({
        url: '/C010104/insertWorkHis',
        method: 'post',
        data: {
            companyId,
            userCd,
            workHisId,
            applicantId,
            companyNm,
            industryId1,
            jobtypeId1_1,
            jobtypeId1_2,
            jobtypeId1_3,
            workPosition,
            workPlace,
            workSkill,
            workDateFrom,
            workDateTo,
            introduction,
            workContent,
        }
    })
}

// 04 削除
export function workExperienceDeleteWorkHis(
    applicantId,
    workHisId,
) {
    console.log("deleteWorkHis is running.", applicantId, workHisId);
    return request({
        url: '/C010104/deleteWorkHis',
        method: 'post',
        data: {
            applicantId,
            workHisId,
        }
    })
}

// 04 編集
export function workExperienceUpdateWorkHis(
    companyId,
    userCd,
    workHisId,
    applicantId,
    companyNm,
    industryId1,
    jobtypeId1_1,
    jobtypeId1_2,
    jobtypeId1_3,
    workPosition,
    workPlace,
    workSkill,
    workDateFrom,
    workDateTo,
    introduction,
    workContent,
) {
    console.log("updateWorkHis is running.");
    return request({
        url: '/C010104/updateWorkHis',
        method: 'post',
        data: {
            companyId,
            userCd,
            workHisId,
            applicantId,
            companyNm,
            industryId1,
            jobtypeId1_1,
            jobtypeId1_2,
            jobtypeId1_3,
            workPosition,
            workPlace,
            workSkill,
            workDateFrom,
            workDateTo,
            introduction,
            workContent,
        }
    })
}

// 05 新規
export function languageSkillsInsertLan(
    companyId,
    userCd,
    applicantId,
    languageId,
    levelSection,
) {
    console.log("insertLan is running.");
    return request({
        url: '/C010105/insertLan',
        method: 'post',
        data: {
            companyId,
            userCd,
            applicantId,
            languageId,
            levelSection,
        }
    })
}

// 05 削除
export function languageSkillsDeleteLan(
    applicantId,
    languageId,
) {
    console.log("deleteLan is running.", applicantId, languageId);
    return request({
        url: '/C010105/deleteLan',
        method: 'post',
        data: {
            applicantId,
            languageId,
        }
    })
}

// 05 編集
export function languageSkillsUpdateLan(
    companyId,
    userCd,
    applicantId,
    languageId,
    levelSection,
    appLanId,
) {
    console.log("updateLan is running.");
    return request({
        url: '/C010105/updateLan',
        method: 'post',
        data: {
            companyId,
            userCd,
            applicantId,
            languageId,
            levelSection,
            appLanId,
        }
    })
}

// 06 新規
export function educationalBackgroundInsertEdu(
    companyId,
    userCd,
    educationId,
    applicantId,
    schoolNm,
    majorNm,
    eduDateFrom,
    eduDateTo,
    degree,
    eduSection,
    degreePic1,
    photoPic,
) {
    console.log("insertEdu is running.");
    return request({
        url: '/C010106/insertEdu',
        method: 'post',
        data: {
            companyId,
            userCd,
            educationId,
            applicantId,
            schoolNm,
            majorNm,
            eduDateFrom,
            eduDateTo,
            degree,
            eduSection,
            degreePic1,
            photoPic,
        }
    })
}

// 06 削除
export function educationalBackgroundDeleteEdu(
    applicantId,
    educationId,
) {
    console.log("deleteEdu is running.", applicantId, educationId);
    return request({
        url: '/C010106/deleteEdu',
        method: 'post',
        data: {
            applicantId,
            educationId,
        }
    })
}

// 06 編集
export function educationalBackgroundUpdateEdu(
    companyId,
    userCd,
    educationId,
    applicantId,
    schoolNm,
    majorNm,
    eduDateFrom,
    eduDateTo,
    degree,
    eduSection,
    degreePic1,
    photoPic,
) {
    console.log("updateEdu is running.");
    return request({
        url: '/C010106/updateEdu',
        method: 'post',
        data: {
            companyId,
            userCd,
            educationId,
            applicantId,
            schoolNm,
            majorNm,
            eduDateFrom,
            eduDateTo,
            degree,
            eduSection,
            degreePic1,
            photoPic,
        }
    })
}

// 07 新規
export function projectExperienceInsertProjectHis(
    companyId,
    userCd,
    projectId,
    applicantId,
    projectNm,
    proDateFrom,
    proDateTo,
    proRole,
    proCnt,
    proDuties,
    proTec,
    proContent,
) {
    console.log("insertProjectHis is running.");
    return request({
        url: '/C010107/insertProjectHis',
        method: 'post',
        data: {
            companyId,
            userCd,
            projectId,
            applicantId,
            projectNm,
            proDateFrom,
            proDateTo,
            proRole,
            proCnt,
            proDuties,
            proTec,
            proContent,
        }
    })
}

// 07 削除
export function projectExperienceDeleteProjectHis(
    applicantId,
    projectId,
) {
    console.log("deleteProjectHis is running.", applicantId, projectId);
    return request({
        url: '/C010107/deleteProjectHis',
        method: 'post',
        data: {
            applicantId,
            projectId,
        }
    })
}

// 07 編集
export function projectExperienceUpdateProjectHis(
    companyId,
    userCd,
    projectId,
    applicantId,
    projectNm,
    proDateFrom,
    proDateTo,
    proRole,
    proCnt,
    proDuties,
    proTec,
    proContent,
) {
    console.log("updateProjectHis is running.");
    return request({
        url: '/C010107/updateProjectHis',
        method: 'post',
        data: {
            companyId,
            userCd,
            projectId,
            applicantId,
            projectNm,
            proDateFrom,
            proDateTo,
            proRole,
            proCnt,
            proDuties,
            proTec,
            proContent,
        }
    })
}

// C01 Detailed 初期
export function getApplicant(
    applicantId,
) {
    return request({
        url: '/C010101/getApplicant',
        method: 'post',
        data: {
            applicantId,
        }
    })
}