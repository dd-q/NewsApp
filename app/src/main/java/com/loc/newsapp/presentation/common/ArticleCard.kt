package com.loc.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.loc.newsapp.R
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.onboarding.Dimens.ArticleCardSize
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding
import com.loc.newsapp.presentation.onboarding.Dimens.ExtraSmallPadding2
import com.loc.newsapp.presentation.onboarding.Dimens.SmallIconSize
import com.loc.newsapp.ui.theme.NewsAppTheme
import com.loc.newsapp.util.Constants.TEMPT_IMAGE_URL

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Row(modifier = modifier.clickable { onClick }){
        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(TEMPT_IMAGE_URL).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop

        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(
                    ArticleCardSize
                )
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.bloggerlink,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = article.postdate,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(article = Article(
            bloggerlink = "blog.naver.com/siren48",
            bloggername = "Dan's Magic Castle",
            description = "&quot;대구 <b>AI</b>학원 미래기술을 터득한 수업과정 후기&quot; 최근 어딜 가든 <b>AI</b> 기술이 활발하게 쓰이고 있어요. 우리가 인식하지 못한 사이에 첨단 기술이 우리 삶에 깊숙하게 스며들고 있죠. 자동차, 냉장고, 스마트폰 등... ",
            link = "https://blog.naver.com/siren48/223521736068",
            postdate = "20240722",
            title = "대구 <b>AI</b>학원 미래기술을 터득한 수업과정 후기"
        )) {

        }
    }
}
