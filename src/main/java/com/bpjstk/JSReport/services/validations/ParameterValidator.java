package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ValidationMessages;
import org.springframework.validation.Errors;

import java.util.regex.Pattern;

public abstract class ParameterValidator {

    public static void validateKantor(RequestModel request, Errors errors) {
        if (request.getP_kantor() == null) {
            errors.rejectValue("p_kantor", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateNoProyek(RequestModel request, Errors errors) {
        if (request.getP_no_proyek() == null) {
            errors.rejectValue("p_no_proyek", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodeKantor(RequestModel request, Errors errors) {
        if (request.getP_kode_kantor() == null) {
            errors.rejectValue("p_kode_kantor", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateLaporan(RequestModel request, Errors errors) {
        if (request.getP_laporan() == null) {
            errors.rejectValue("p_laporan", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateDivisi(RequestModel request, Errors errors) {
        if (request.getP_divisi() == null) {
            errors.rejectValue("p_divisi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validatePeriode(RequestModel request, Errors errors) {
        String pPeriode = request.getP_periode();
        if (pPeriode == null) {
            errors.rejectValue("p_periode", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            if (pPeriode.length() != 10) {
                errors.rejectValue("p_periode", "invalid.length", ValidationMessages.P_PERIODE_LENGTH);
            } else {
                if (!isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", pPeriode)) {
                    errors.rejectValue("p_periode", "invalid.format", ValidationMessages.P_PERIODE_FORMAT);
                }
            }
        }
    }

    public static void validatePeriode1(RequestModel request, Errors errors) {
        String pPeriode = request.getP_periode1();
        if (pPeriode == null) {
            errors.rejectValue("p_periode1", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            if (pPeriode.length() != 10) {
                errors.rejectValue("p_periode1", "invalid.length", ValidationMessages.P_PERIODE_LENGTH);
            } else {
                if (!isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", pPeriode)) {
                    errors.rejectValue("p_periode1", "invalid.format", ValidationMessages.P_PERIODE_FORMAT);
                }
            }
        }
    }

    public static void validatePeriode2(RequestModel request, Errors errors) {
        String pPeriode = request.getP_periode2();
        if (pPeriode == null) {
            errors.rejectValue("p_periode2", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            if (pPeriode.length() != 10) {
                errors.rejectValue("p_periode2", "invalid.length", ValidationMessages.P_PERIODE_LENGTH);
            } else {
                if (!isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", pPeriode)) {
                    errors.rejectValue("p_periode2", "invalid.format", ValidationMessages.P_PERIODE_FORMAT);
                }
            }
        }
    }


    public static void validateKodeTema(RequestModel request, Errors errors) {
        if (request.getP_kd_tema() == null) {
            errors.rejectValue("p_kd_tema", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validatePerusahaan(RequestModel request, Errors errors) {
        if (request.getP_perusahaan() == null) {
            errors.rejectValue("p_perusahaan", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateChannel(RequestModel request, Errors errors) {
        if (request.getP_channel() == null) {
            errors.rejectValue("p_channel", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateTema(RequestModel request, Errors errors) {
        if (request.getP_tema() == null) {
            errors.rejectValue("p_tema", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateBlthProses(RequestModel request, Errors errors) {
        String pPeriode = request.getP_blth_proses();
        if (pPeriode == null) {
            errors.rejectValue("p_blth_proses", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            if (pPeriode.length() != 10) {
                errors.rejectValue("p_blth_proses", "invalid.length", ValidationMessages.P_PERIODE_LENGTH);
            }
            if (!isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", pPeriode)) {
                errors.rejectValue("p_blth_proses", "invalid.format", ValidationMessages.P_PERIODE_FORMAT);
            }
        }
    }

    public static void validateTglProses(RequestModel request, Errors errors) {
        String pPeriode = request.getP_tgl_proses();
        if (pPeriode == null) {
            errors.rejectValue("p_tgl_proses", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            if (pPeriode.length() != 10) {
                errors.rejectValue("p_tgl_proses", "invalid.length", ValidationMessages.P_PERIODE_LENGTH);
            }
            if (!isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", pPeriode)) {
                errors.rejectValue("p_tgl_proses", "invalid.format", ValidationMessages.P_PERIODE_FORMAT);
            }
        }
    }

    public static void validateSegmen(RequestModel request, Errors errors) {
        if (request.getP_segmen() == null) {
            errors.rejectValue("p_segmen", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateUser(RequestModel request, Errors errors) {
        if (request.getP_user() == null) {
            errors.rejectValue("p_user", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateProgram(RequestModel request, Errors errors) {
        if (request.getP_program() == null) {
            errors.rejectValue("p_program", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodeWilayah(RequestModel request, Errors errors) {
        if (request.getP_kode_wilayah() == null) {
            errors.rejectValue("p_kode_wilayah", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateWilayah(RequestModel request, Errors errors) {
        if (request.getP_wilayah() == null) {
            errors.rejectValue("p_wilayah", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateBadanHukum(RequestModel request, Errors errors) {
        if (request.getP_badan_hukum() == null) {
            errors.rejectValue("p_badan_hukum", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodeIlo(RequestModel request, Errors errors) {
        if (request.getP_kode_ilo() == null) {
            errors.rejectValue("p_kode_ilo", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }



    public static void validateKomunitas(RequestModel request, Errors errors) {
        if (request.getP_komunitas() == null) {
            errors.rejectValue("p_komunitas", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateSaldo(RequestModel request, Errors errors) {
        if (request.getP_saldo() == null) {
            errors.rejectValue("p_saldo", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateSaldo2(RequestModel request, Errors errors) {
        if (request.getP_saldo2() == null) {
            errors.rejectValue("p_saldo2", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKementrian(RequestModel request, Errors errors) {
        if (request.getP_kementrian() == null) {
            errors.rejectValue("p_kementrian", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateMitra(RequestModel request, Errors errors) {
        if (request.getP_mitra() == null) {
            errors.rejectValue("p_mitra", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKolektor(RequestModel request, Errors errors) {
        if (request.getP_kolektor() == null) {
            errors.rejectValue("p_kolektor", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    private static boolean isValidDateFormat(String date_format, String dateStr) {
        Pattern date_pattern = Pattern.compile(date_format);
        return date_pattern.matcher(dateStr).matches();
    }


    public static void validateKodeKabupaten(RequestModel request, Errors errors) {
        if (request.getP_kode_kabupaten() == null) {
            errors.rejectValue("p_kode_kabupaten", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodeProvinsi(RequestModel request, Errors errors) {
        if (request.getP_kode_provinsi() == null) {
            errors.rejectValue("p_kode_provinsi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateNpp(RequestModel request, Errors errors) {
        if (request.getP_npp() == null) {
            errors.rejectValue("p_npp", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateSumberDana(RequestModel request, Errors errors) {
        if (request.getP_sumber_dana() == null) {
            errors.rejectValue("p_sumber_dana", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateProvinsi(RequestModel request, Errors errors) {
        if (request.getP_provinsi() == null) {
            errors.rejectValue("p_provinsi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKabupaten(RequestModel request, Errors errors) {
        if (request.getP_kabupaten() == null) {
            errors.rejectValue("p_kabupaten", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKonsolidasi(RequestModel request, Errors errors) {
        if (request.getP_konsolidasi() == null) {
            errors.rejectValue("p_konsolidasi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validatePembina(RequestModel request, Errors errors) {
        if (request.getP_pembina() == null) {
            errors.rejectValue("p_pembina", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateBlth(RequestModel request, Errors errors) {
        if (request.getP_blth() == null) {
            errors.rejectValue("p_blth", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateRole(RequestModel request, Errors errors) {
        if (request.getP_role() == null) {
            errors.rejectValue("p_role", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodeSegmen(RequestModel request, Errors errors) {
        if (request.getP_kode_segmen() == null) {
            errors.rejectValue("p_kode_segmen", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKodePembina(RequestModel request, Errors errors) {
        if (request.getP_kode_pembina() == null) {
            errors.rejectValue("p_kode_pembina", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateKondisi(RequestModel request, Errors errors) {
        if (request.getP_kondisi() == null) {
            errors.rejectValue("p_kondisi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateUsia(RequestModel request, Errors errors) {
        if (request.getP_usia() == null) {
            errors.rejectValue("p_usia", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateUsia2(RequestModel request, Errors errors) {
        if (request.getP_usia2() == null) {
            errors.rejectValue("p_usia2", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQktr(RequestModel request, Errors errors) {
        if (request.getQktr() == null) {
            errors.rejectValue("qktr", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQsegmen(RequestModel request, Errors errors) {
        if (request.getQsegmen() == null) {
            errors.rejectValue("qsegmen", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQkonsolidasi(RequestModel request, Errors errors) {
        if (request.getQkonsolidasi() == null) {
            errors.rejectValue("qkonsolidasi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQuser(RequestModel request, Errors errors) {
        if (request.getQuser() == null) {
            errors.rejectValue("quser", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQfungsi(RequestModel request, Errors errors) {
        if (request.getQfungsi() == null) {
            errors.rejectValue("qfungsi", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQstatus(RequestModel request, Errors errors) {
        if (request.getQstatus() == null) {
            errors.rejectValue("qstatus", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }


    public static void validateQtgl(RequestModel request, Errors errors) {
        String qtgl = request.getQtgl();
        if (qtgl == null) {
            errors.rejectValue("qtgl", "required", ValidationMessages.FIELD_REQUIRED);
        } else {
            // Jika panjang qtgl tidak sama dengan 10 karakter untuk format dd-MM-yyyy, dan tidak 8 karakter untuk format yyyyMMdd
            if (qtgl.length() != 10 && qtgl.length() != 8) {
                errors.rejectValue("qtgl", "invalid.length", ValidationMessages.QTGL_LENGTH);
            } else {
                // Jika qtgl sesuai dengan format dd-MM-yyyy
                if (qtgl.length() == 10 && !isValidDateFormat("^\\d{2}-\\d{2}-\\d{4}$", qtgl)) {
                    errors.rejectValue("qtgl", "invalid.format", ValidationMessages.QTGL_FORMAT);
                }
                // Jika qtgl sesuai dengan format yyyyMMdd
                else if (qtgl.length() == 8 && !isValidDateFormat("^\\d{4}\\d{2}\\d{2}$", qtgl)) {
                    errors.rejectValue("qtgl", "invalid.format", ValidationMessages.QTGL_FORMAT);
                }
            }
        }
    }

    public static void validateQakun(RequestModel request, Errors errors) {
        if (request.getQakun() == null) {
            errors.rejectValue("qakun", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQkodebuku(RequestModel request, Errors errors) {
        if (request.getQkodebuku() == null) {
            errors.rejectValue("qkodebuku", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQstatussaldo(RequestModel request, Errors errors) {
        if (request.getQstatussaldo() == null) {
            errors.rejectValue("qstatussaldo", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQjenis(RequestModel request, Errors errors) {
        if (request.getQjenis() == null) {
            errors.rejectValue("qjenis", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQstatusLapkeu(RequestModel request, Errors errors) {
        if (request.getQstatuslapkeu() == null) {
            errors.rejectValue("qstatuslapkeu", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }

    public static void validateQprgLapkeu(RequestModel request, Errors errors) {
        if (request.getQprglapkeu() == null) {
            errors.rejectValue("qprglapkeu", "required", ValidationMessages.FIELD_REQUIRED);
        }
    }


}
