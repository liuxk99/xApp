LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

res_dirs := res
src_dirs := src

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under,$(src_dirs))

# unbundled
LOCAL_STATIC_JAVA_LIBRARIES += android-support-v4

LOCAL_SDK_VERSION := current

LOCAL_RESOURCE_DIR := $(addprefix $(LOCAL_PATH)/, $(res_dirs))

LOCAL_PACKAGE_NAME := xApp

LOCAL_PROGUARD_FLAG_FILES := proguard-project.txt

ifneq ($(filter letv_jason%, $(TARGET_PRODUCT)),)
LOCAL_VENDOR_MODULE := true
endif

include $(BUILD_PACKAGE)

# Use the following include to make our test apk.
include $(call all-makefiles-under,$(LOCAL_PATH))
