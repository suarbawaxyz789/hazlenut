package ninjavan.swiftninja.mvvm.ui.groupbypostcode.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.JobType
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.uistate.TidWithJobStatus
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.CustomEllipsisText
import com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base.IconByJobType
import com.example.hazelnut.ui.features.ninjas.nonakira.StatusValue

@Composable
fun JobTypeLabel(
    type: JobType,
    parcels: List<TidWithJobStatus>,
    isMultipleJobType: Boolean,
    enable: Boolean = true
) {
    if (parcels.isEmpty()) return Row {
        IconByJobType(type = type, enable = enable)
    }
    if (isMultipleJobType || parcels.size > 1) {
        return Row(verticalAlignment = Alignment.CenterVertically) {
            IconByJobType(type = type, enable = enable)
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxxs))
            when (type) {
                JobType.DELIVERY -> Text(
                    text = parcels.filter { !(it.jobStatus == StatusValue.SUCCESS.toString() || it.jobStatus == StatusValue.FAIL.toString()) }.size.toString(),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RTS -> Text(
                    text = stringResource(R.string.num_of_rts_parcels, parcels.filter { !(it.jobStatus == StatusValue.SUCCESS.toString() || it.jobStatus == StatusValue.FAIL.toString()) }.size),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.RPU -> Text(
                    text = stringResource(R.string.num_of_rpu_parcels, parcels.filter { !(it.jobStatus == StatusValue.SUCCESS.toString() || it.jobStatus == StatusValue.FAIL.toString()) }.size),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )

                JobType.PICKUP -> Text(
                    text = parcels.filter { !(it.jobStatus == StatusValue.SUCCESS.toString() || it.jobStatus == StatusValue.FAIL.toString()) }.size.toString(),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray1 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
            }
            Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
        }
    }

    return Row(verticalAlignment = Alignment.CenterVertically) {
        IconByJobType(type = type, enable = enable)
        Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxxs))
        when (type) {
            JobType.DELIVERY -> {}
            JobType.RTS -> Row {
                Text(
                    text = stringResource(id = R.string.parcel_rts),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            }

            JobType.RPU -> Row {
                Text(
                    text = stringResource(id = R.string.text_rpu_tag),
                    style = AkiraTheme.typography.body2.copy(
                        color = if (enable) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray5
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.width(AkiraTheme.spacings.spacingXxs))
            }

            JobType.PICKUP -> {}
        }

        CustomEllipsisText(
            text = parcels.first().trackingId,
            style = AkiraTheme.typography.body2.copy(
                color = if (enable) AkiraTheme.colors.gray3 else AkiraTheme.colors.gray5
            ),
        )
    }
}